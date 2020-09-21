package com.philips.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.philips.demo.dto.ServerResponse;
import com.philips.demo.request.dto.TrainingJobRequestDTO;
import com.philips.demo.service.SageMaker;
import com.philips.demo.util.ServerResponseCode;

@RestController
@RequestMapping("/sagemaker/")
public class SagemakerController {

	@Autowired
	SageMaker sageMakerService;
	
	@RequestMapping(value = "createtrainingjob", method = RequestMethod.POST)
	public ServerResponse createtrainingjob(@RequestBody TrainingJobRequestDTO trainingJobRequestDTO) {
		try {
			sageMakerService.createTrainingJob(trainingJobRequestDTO);
			return getServerResponse(ServerResponseCode.SUCCESS, trainingJobRequestDTO);
		} catch (Exception expObj) {
			return getServerResponse(ServerResponseCode.SUCCESS, expObj);
		}
		
	}
	
	@RequestMapping("getjobstatus")
	public ServerResponse getjobstatus(@RequestParam("jobName") String jobName, @RequestParam("accessKey") String accessKey, @RequestParam("secrateKey") String secrateKey) {
		String status = sageMakerService.getTrainingJobStatus(jobName, accessKey, secrateKey);
		return getServerResponse(ServerResponseCode.SUCCESS, status);
	}

	public ServerResponse getServerResponse(int responseCode, Object data) {
		ServerResponse serverResponse = new ServerResponse();
		serverResponse.setStatusCode(responseCode);
		serverResponse.setData(data);
		return serverResponse;
	}
}
