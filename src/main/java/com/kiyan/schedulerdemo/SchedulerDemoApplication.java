package com.kiyan.schedulerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class SchedulerDemoApplication {
	Logger logger = LoggerFactory.getLogger(SchedulerDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SchedulerDemoApplication.class, args);
	}

	@Scheduled(cron = "*/2 * * * * *")
	public void job() throws InterruptedException {
		logger.info("Job Current 1 Date and Time is :" + new Date());
		Thread.sleep(2000L);
	}

	@Scheduled(cron = "*/2 * * * * *")
	public void jobTwo() throws InterruptedException {
		logger.info("Job Current 2 Date and Time is :" + new Date());
		Thread.sleep(2000L);
	}

}
