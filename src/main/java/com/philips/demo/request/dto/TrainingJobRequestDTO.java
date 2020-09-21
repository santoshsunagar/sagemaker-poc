package com.philips.demo.request.dto;

public class TrainingJobRequestDTO {

	private String id;
	private String resourceType;
	private String type;
	private String createdBy;
	private String status;
	private String created;
	private String entryCommand;
	private String roleArn;
	private String jobName;
	private String trainingImage;
	private String trainingInputMode;
	private String instanceCount;
	private String instanceType;
	private String volumeSizeInGB;
	private String channelName;
	private String inputS3Uri;
	private String inputS3DataType;
	private String s3OutputPath;
	private String maxRuntimeInSeconds;
	private String awsAccessKey;
	private String awsSecretKey;
	
	public TrainingJobRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public TrainingJobRequestDTO(String id, String resourceType, String type, String createdBy, String status,
			String created, String entryCommand, String roleArn, String jobName, String trainingImage,
			String trainingInputMode, String instanceCount, String instanceType, String volumeSizeInGB,
			String channelName, String inputS3Uri, String inputS3DataType, String s3OutputPath,
			String maxRuntimeInSeconds, String awsAccessKey, String awsSecretKey) {
		super();
		this.id = id;
		this.resourceType = resourceType;
		this.type = type;
		this.createdBy = createdBy;
		this.status = status;
		this.created = created;
		this.entryCommand = entryCommand;
		this.roleArn = roleArn;
		this.jobName = jobName;
		this.trainingImage = trainingImage;
		this.trainingInputMode = trainingInputMode;
		this.instanceCount = instanceCount;
		this.instanceType = instanceType;
		this.volumeSizeInGB = volumeSizeInGB;
		this.channelName = channelName;
		this.inputS3Uri = inputS3Uri;
		this.inputS3DataType = inputS3DataType;
		this.s3OutputPath = s3OutputPath;
		this.maxRuntimeInSeconds = maxRuntimeInSeconds;
		this.awsAccessKey = awsAccessKey;
		this.awsSecretKey = awsSecretKey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEntryCommand() {
		return entryCommand;
	}

	public void setEntryCommand(String entryCommand) {
		this.entryCommand = entryCommand;
	}

	public String getRoleArn() {
		return roleArn;
	}

	public void setRoleArn(String roleArn) {
		this.roleArn = roleArn;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getTrainingImage() {
		return trainingImage;
	}

	public void setTrainingImage(String trainingImage) {
		this.trainingImage = trainingImage;
	}

	public String getTrainingInputMode() {
		return trainingInputMode;
	}

	public void setTrainingInputMode(String trainingInputMode) {
		this.trainingInputMode = trainingInputMode;
	}

	public String getInstanceCount() {
		return instanceCount;
	}

	public void setInstanceCount(String instanceCount) {
		this.instanceCount = instanceCount;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}

	public String getVolumeSizeInGB() {
		return volumeSizeInGB;
	}

	public void setVolumeSizeInGB(String volumeSizeInGB) {
		this.volumeSizeInGB = volumeSizeInGB;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getInputS3Uri() {
		return inputS3Uri;
	}

	public void setInputS3Uri(String inputS3Uri) {
		this.inputS3Uri = inputS3Uri;
	}

	public String getInputS3DataType() {
		return inputS3DataType;
	}

	public void setInputS3DataType(String inputS3DataType) {
		this.inputS3DataType = inputS3DataType;
	}

	public String getS3OutputPath() {
		return s3OutputPath;
	}

	public void setS3OutputPath(String s3OutputPath) {
		this.s3OutputPath = s3OutputPath;
	}

	public String getMaxRuntimeInSeconds() {
		return maxRuntimeInSeconds;
	}

	public void setMaxRuntimeInSeconds(String maxRuntimeInSeconds) {
		this.maxRuntimeInSeconds = maxRuntimeInSeconds;
	}

	public String getAwsAccessKey() {
		return awsAccessKey;
	}

	public void setAwsAccessKey(String awsAccessKey) {
		this.awsAccessKey = awsAccessKey;
	}

	public String getAwsSecretKey() {
		return awsSecretKey;
	}

	public void setAwsSecretKey(String awsSecretKey) {
		this.awsSecretKey = awsSecretKey;
	}

}
