package com.tesco.quartzdynamicscheduling;

import java.io.IOException;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExecuteJarFile implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		Map dataMap = context.getJobDetail().getJobDataMap();
		
		JarExecutionService jarExecutionService = (JarExecutionService) context.getJobDetail().getJobDataMap().get("jarService");
		
		String jarPath = (String) dataMap.get("executablepath");
		String configpath = (String) dataMap.get("configfilePath");
		String profile = (String) dataMap.get("profile");
		String logpath = (String) dataMap.get("logpath");
		String command = (String) dataMap.get("command");
		
		try {
			jarExecutionService.executejob(command, jarPath, configpath, profile, logpath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
