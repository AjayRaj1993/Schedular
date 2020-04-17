package com.tesco.quartzdynamicscheduling.entity;

public class JobData {
	
	private int id;
	
	private String jobName;
	
	private String jobDescription;
	
	private String recipients;
	
	private String startDateTime;
	
	private boolean active;
	
	private String executablePath;
	
	private String configFilePath;
	
	private String profile;
	
	private String cronExpression;
	
	
	public JobData(){
		
	}
	public JobData(int id, String jobName, String jobDescription, String recipients, String startDateTime, boolean active,
			String executablePath, String configFilePath, String profile, String cronExpression) {
		this.id = id;
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.recipients = recipients;
		this.startDateTime = startDateTime;
		this.active = active;
		this.executablePath = executablePath;
		this.configFilePath = configFilePath;
		this.profile = profile;
		this.cronExpression = cronExpression;
	}









	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}


	public String getExecutablePath() {
		return executablePath;
	}

	public void setExecutablePath(String executablePath) {
		this.executablePath = executablePath;
	}

	public String getConfigFilePath() {
		return configFilePath;
	}



	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}


	

	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCronExpression() {
		return cronExpression;
	}
	
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	@Override
	public String toString() {
		return "JobData [id=" + id + ", jobName=" + jobName + ", jobDescription=" + jobDescription + ", recipients="
				+ recipients + ", startDateTime=" + startDateTime + ", active=" + active + ", executablePath="
				+ executablePath + ", configFilePath=" + configFilePath + ", profile=" + profile + "]";
	}


	
	
}
