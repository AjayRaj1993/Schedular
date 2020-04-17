package com.tesco.quartzdynamicscheduling;

import org.springframework.stereotype.Service;

@Service
public class MailService implements SendNotification {

	@Override
	public void sendNotification() {
		
		System.out.println("Job Executed Successfully");
	}
	
	

}
