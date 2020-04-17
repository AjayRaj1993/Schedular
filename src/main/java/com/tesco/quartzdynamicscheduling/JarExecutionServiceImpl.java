package com.tesco.quartzdynamicscheduling;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class JarExecutionServiceImpl implements JarExecutionService {

	
	@Override
	public void executejob(String command, String jarPath, String configpath, String profile, String logPath) throws IOException {
		
		Runtime.getRuntime().exec(getCommandStatement(command,jarPath,configpath,profile),null, new File(logPath));
		
		System.out.println(getCommandStatement(command, jarPath, configpath, profile));
		
	}

	private String getCommandStatement(String command, String jarPath, String configpath, String profile) {
		
		String cmdStatement = command + " " + jarPath + " " + configpath + " " + profile;
		
		return cmdStatement;
	}

}
