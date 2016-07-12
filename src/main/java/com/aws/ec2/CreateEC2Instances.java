package com.aws.ec2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

/**
 * This sample program 
 * creates EC2 instances using 
 * AWS SDK for java
 * @author sudheer
 *
 */
		
public class CreateEC2Instances {


	public static void main(String[] args) throws InterruptedException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/bean.xml");

		AWSCredentials awsCredentials = (BasicAWSCredentials)ctx.getBean("basicAWSCred");
		System.out.println(awsCredentials.getAWSAccessKeyId());
		AmazonEC2Client amazonEC2Client = new AmazonEC2Client(awsCredentials);
		amazonEC2Client.setEndpoint("ec2.us-west-2.amazonaws.com");
		RunInstancesRequest runInstancesRequest =
				new RunInstancesRequest();

		runInstancesRequest.withImageId("ami-7172b611")
		.withInstanceType("t2.micro")
		.withMinCount(1)
		.withMaxCount(1);



		RunInstancesResult runInstancesResult =
				amazonEC2Client.runInstances(runInstancesRequest);

		List<Instance> instanceList = runInstancesResult.getReservation().getInstances();
		
		instanceList = runInstancesResult.getReservation().getInstances();
		System.out.println(instanceList.get(0).getState());
		String instanceId = instanceList.get(0).getInstanceId();
		System.out.println("instanceId = "+instanceId);
		((ClassPathXmlApplicationContext)ctx).close();
	}

	


}
