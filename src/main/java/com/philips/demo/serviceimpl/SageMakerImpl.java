package com.philips.demo.serviceimpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sagemaker.AmazonSageMaker;
import com.amazonaws.services.sagemaker.AmazonSageMakerClientBuilder;
import com.amazonaws.services.sagemaker.model.AlgorithmSpecification;
import com.amazonaws.services.sagemaker.model.AmazonSageMakerException;
import com.amazonaws.services.sagemaker.model.Channel;
import com.amazonaws.services.sagemaker.model.CreateTrainingJobRequest;
import com.amazonaws.services.sagemaker.model.DataSource;
import com.amazonaws.services.sagemaker.model.DescribeTrainingJobRequest;
import com.amazonaws.services.sagemaker.model.DescribeTrainingJobResult;
import com.amazonaws.services.sagemaker.model.OutputDataConfig;
import com.amazonaws.services.sagemaker.model.ResourceConfig;
import com.amazonaws.services.sagemaker.model.ResourceNotFoundException;
import com.amazonaws.services.sagemaker.model.S3DataSource;
import com.amazonaws.services.sagemaker.model.StoppingCondition;
import com.philips.demo.request.dto.TrainingJobRequestDTO;
import com.philips.demo.service.SageMaker;

@Service
public class SageMakerImpl implements SageMaker {

	AmazonSageMaker sageMakeService;

	@Override
	public void createTrainingJob(TrainingJobRequestDTO trainingJobRequestDTO) {
		try {
			sageMakeService = AmazonSageMakerClientBuilder.standard().withRegion(Regions.US_EAST_2)
					.withCredentials(new AWSCredentialsProvider() {
						@Override
						public void refresh() {
							// TODO Auto-generated method stub

						}

						@Override
						public AWSCredentials getCredentials() {
							AWSCredentials credentials = new AWSCredentials() {
								@Override
								public String getAWSSecretKey() {
									// TODO Auto-generated method stub
									return trainingJobRequestDTO.getAwsSecretKey();
								}

								@Override
								public String getAWSAccessKeyId() {
									// TODO Auto-generated method stub
									return trainingJobRequestDTO.getAwsAccessKey();
								}
							};
							return credentials;
						}
					}).build();
			CreateTrainingJobRequest createTrainingJobRequest = new CreateTrainingJobRequest();
			// TODO: set all attributes here
			createTrainingJobRequest.setRoleArn(trainingJobRequestDTO.getRoleArn());
			createTrainingJobRequest.setTrainingJobName(trainingJobRequestDTO.getJobName());
			AlgorithmSpecification algorithmSpecification = new AlgorithmSpecification();
			algorithmSpecification.setTrainingImage(trainingJobRequestDTO.getTrainingImage());
			algorithmSpecification.setTrainingInputMode(trainingJobRequestDTO.getTrainingInputMode());
			createTrainingJobRequest.setAlgorithmSpecification(algorithmSpecification);
			OutputDataConfig outputDataConfig = new OutputDataConfig();
			outputDataConfig.setS3OutputPath(trainingJobRequestDTO.getS3OutputPath());
			createTrainingJobRequest.setOutputDataConfig(outputDataConfig);
			ResourceConfig resourceConfig = new ResourceConfig();
			resourceConfig.setInstanceCount(Integer.parseInt(trainingJobRequestDTO.getInstanceCount()));
			resourceConfig.setInstanceType(trainingJobRequestDTO.getInstanceType());
			resourceConfig.setVolumeSizeInGB(Integer.parseInt(trainingJobRequestDTO.getVolumeSizeInGB()));
			createTrainingJobRequest.setResourceConfig(resourceConfig);
			java.util.List<Channel> inputDataConfig = new ArrayList<Channel>();
			Channel channel = new Channel();
			channel.setChannelName(trainingJobRequestDTO.getChannelName());
			DataSource dataSource = new DataSource();
			S3DataSource s3DataSource = new S3DataSource();
			s3DataSource.setS3Uri(trainingJobRequestDTO.getInputS3Uri());
			s3DataSource.setS3DataType(trainingJobRequestDTO.getInputS3DataType());
			dataSource.setS3DataSource(s3DataSource);
			channel.setDataSource(dataSource);
			inputDataConfig.add(channel);
			createTrainingJobRequest.setInputDataConfig(inputDataConfig);
			StoppingCondition stoppingCondition = new StoppingCondition();
			stoppingCondition.setMaxRuntimeInSeconds(Integer.parseInt(trainingJobRequestDTO.getMaxRuntimeInSeconds()));
			createTrainingJobRequest.setStoppingCondition(stoppingCondition);
			sageMakeService.createTrainingJob(createTrainingJobRequest);
		} catch (Exception expObj) {
			expObj.printStackTrace();
			throw new AmazonSageMakerException(expObj.getMessage());
		}
	}

	@Override
	public String getTrainingJobStatus(String jobName, String accessKey, String secrateKey) {
		String status = null;
		try {
			sageMakeService = AmazonSageMakerClientBuilder.standard().withRegion(Regions.US_EAST_2)
					.withCredentials(new AWSCredentialsProvider() {
						@Override
						public void refresh() {
							// TODO Auto-generated method stub

						}

						@Override
						public AWSCredentials getCredentials() {
							AWSCredentials credentials = new AWSCredentials() {
								@Override
								public String getAWSSecretKey() {
									// TODO Auto-generated method stub
									return secrateKey;
								}

								@Override
								public String getAWSAccessKeyId() {
									// TODO Auto-generated method stub
									return accessKey;
								}
							};
							return credentials;
						}
					}).build();
			DescribeTrainingJobRequest request = new DescribeTrainingJobRequest()
					.withTrainingJobName(jobName);
			DescribeTrainingJobResult result = sageMakeService.describeTrainingJob(request);
			status = result.getSecondaryStatus();
			System.out.println("Status: " + status);
		} catch (ResourceNotFoundException e) {
			status = "Resource Not Found";
		} catch (Exception expObj) {
			status = "Exception invoking  describeTrainingJob";
		}
		return status;
	}

	public static void main(String[] args) {
		new SageMakerImpl().createTrainingJob(new TrainingJobRequestDTO());
	}
	
}
