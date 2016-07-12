package com.aws.ec2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;

/**
 * This class terminates all the instances that
 * are running related to the user
 * @author sudheer
 *
 */
public class TerminateEC2Instances {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		BasicAWSCredentials basicAWSCredentials = (BasicAWSCredentials)ctx.getBean("basicAWSCred");
		AmazonEC2Client amazonEC2Client = new AmazonEC2Client(basicAWSCredentials);
		
		
		
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
