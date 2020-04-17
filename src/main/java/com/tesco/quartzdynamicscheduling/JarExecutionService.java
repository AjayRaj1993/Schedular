package com.tesco.quartzdynamicscheduling;

import java.io.IOException;

public interface JarExecutionService {
	
	public void executejob(String command, String jarPath, String configpath, String profile, String logPath) throws IOException;

}
