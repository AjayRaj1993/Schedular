package com.tesco.quartzdynamicscheduling;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesco.quartzdynamicscheduling.entity.ConfigurationService;
import com.tesco.quartzdynamicscheduling.entity.JobData;

@Service
public class PersistentJobSchedulerJobServiceImpl implements PersistentJobSchedulerJobService {
	
	//private static Logger logger = Logger.getLogger("PersistentJobSchedulerJob");
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private ConfigurationService configService;
	
	@Autowired
	private JarExecutionService jarService;
	
	private static final String logpath = "/Users/ajayrajanna/POC";
	private static final String command = "java -jar";
	
	
	
	public void schedulePersistentJobs(){
		List<JobData> jobsData= configService.getJobdata();
		System.out.println("Retriving Jobs from Database and Scheduling One by One | Total Number of Jobs: "+jobsData.size());
		try{
			Scheduler scheduler = new StdSchedulerFactory().getScheduler(); 
	        scheduler.start();  
			for(JobData jobData: jobsData){
				JobDetail job = newJob(ExecuteJarFile.class)
								.withIdentity(jobData.getJobName())
								.usingJobData(getJobDataMap(jobData))
								.build();
				if(jobData.isActive()){
					System.out.println("Deleting a Job");
					if(scheduler.checkExists(new JobKey(jobData.getJobName())))
						scheduler.deleteJob(new JobKey(jobData.getJobName()));
					continue;
				}
				if(scheduler.checkExists(new JobKey(jobData.getJobName()))){
					System.out.println("Rescheduling the Job");
					Trigger oldTrigger = scheduler.getTrigger(new TriggerKey(jobData.getJobName()+"Trigger"));
					TriggerBuilder tb = oldTrigger.getTriggerBuilder();
					Trigger newTrigger = tb.withSchedule(CronScheduleBuilder.cronSchedule(jobData.getCronExpression()))
							  .build();

					scheduler.rescheduleJob(oldTrigger.getKey(), newTrigger);
				}else{
					System.out.println("Scheduling the Job");
					scheduler.scheduleJob(job,getTrigger(jobData));
				}
			}
		}catch (SchedulerException e) {
			System.out.println("Scheduler Exception : "+e.getMessage());	
		}
	}

	private JobDataMap getJobDataMap(JobData jobData) {
		JobDataMap jobDataMap =  new JobDataMap();
		jobDataMap.put("recipients", jobData.getRecipients());
		jobDataMap.put("mailService", mailService);
		jobDataMap.put("jarService", jarService);
		jobDataMap.put("executablepath", jobData.getExecutablePath());
		jobDataMap.put("executablepath", jobData.getExecutablePath());
		jobDataMap.put("configfilePath", jobData.getConfigFilePath());
		jobDataMap.put("profile", jobData.getProfile());
		jobDataMap.put("logpath", logpath);
		jobDataMap.put("command", command);
		return jobDataMap;
	}
	
	private Trigger getTrigger(JobData jobData){
		CronTrigger cronTrigger = newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(jobData.getCronExpression()))
										  .build();
		return cronTrigger;
	}
}
