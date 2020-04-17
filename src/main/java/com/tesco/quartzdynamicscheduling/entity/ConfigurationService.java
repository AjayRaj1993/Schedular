package com.tesco.quartzdynamicscheduling.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "jobs")
public class ConfigurationService {
    private List<JobData> jobdata = new ArrayList<>();

    @PostConstruct
    public void init() {
        for(JobData current : this.getJobdata()) {
             System.out.println(current);
        }
    }

	public List<JobData> getJobdata() {
		return jobdata;
	}

    
}