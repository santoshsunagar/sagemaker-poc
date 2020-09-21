package com.philips.demo.service;

import com.philips.demo.request.dto.TrainingJobRequestDTO;

public interface SageMaker {

	public void createTrainingJob(TrainingJobRequestDTO trainingJobRequestDTO);
	
	public String getTrainingJobStatus(String jobName, String accessKey, String secrateKey);
	
}
