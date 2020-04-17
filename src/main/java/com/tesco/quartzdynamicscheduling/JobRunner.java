package com.tesco.quartzdynamicscheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JobRunner implements CommandLineRunner{

	@Autowired
	private PersistentJobSchedulerJobService jobService;
	@Override
	public void run(String... args) throws Exception {
		
		jobService.schedulePersistentJobs();
	}

}
