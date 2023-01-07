# schedular-demo

Schedular is part of Spring core. so need of any dependancy.
@SpringBootApplication
@EnableScheduling
This Scheduling will be enabled at the time of junit implementation as well.
Create different configuration class for scheudling there we can use conditional on property annotation.
on which scheduling should be enabled.

On top the method use @Scheduled
@Scheduled(fixedRate = 2000L)
Assume that this method take almost 5 Seconds to complete. 
Method will execute for every 2 seconds irrespect whether method complete or not. notice the below output
 2023-01-06 10:26:23.585 [scheduling-1] c.k.s.SchedulerDemoApplication: Job Current Date and Time is :Fri Jan 06 10:26:23 IST 2023
 2023-01-06 10:26:25.589 [scheduling-1] c.k.s.SchedulerDemoApplication: Job Current Date and Time is :Fri Jan 06 10:26:25 IST 2023
 2023-01-06 10:26:27.591 [scheduling-1] c.k.s.SchedulerDemoApplication: Job Current Date and Time is :Fri Jan 06 10:26:27 IST 2023

@Scheduled(fixedDelay = 2000L). it will execute once method is complete. then wait for 2 seconds. notice the below output
  2023-01-06 10:23:46.287 [scheduling-1] c.k.s.SchedulerDemoApplication: Job Current Date and Time is :Fri Jan 06 10:23:46 IST 2023
  2023-01-06 10:23:50.294 [scheduling-1] c.k.s.SchedulerDemoApplication: Job Current Date and Time is :Fri Jan 06 10:23:50 IST 2023
  2023-01-06 10:23:54.304 [scheduling-1] c.k.s.SchedulerDemoApplication: Job Current Date and Time is :Fri Jan 06 10:23:54 IST 2023

@Scheduled(fixedRate = 2000L, initialDelay = 2000L) 
This will start after the application start and wait for 2 secondns then start the job for every two seconds

@Scheduled(fixedDelayString = "PT2S") this is another way where we run 2 seconds after method execution
@Scheduled(fixedRateString = "PT2H"). this is another way where we run for every 2 hours.

P represent Period
T represent Time
S represent seconds
H represent hours
for doucmentation google 

Give the values in properties. so for any change we no need to touch the code.


@Scheduled(cron = "*/2 * * * * *") it is working like fixed delay. after method execution after 2 seconds it is working. 
Use https://crontab.guru/

When we have more than one @Scheduled only one thread is allocated to run two jobs. which is not effective. 

  2023-01-06 13:54:32.012[scheduling-1] c.k.s.SchedulerDemoApplication: Job Current 2 Date and Time is :Fri Jan 06 13:54:32 IST 2023
  2023-01-06 13:54:34.018[scheduling-1] c.k.s.SchedulerDemoApplication: Job Current 1 Date and Time is :Fri Jan 06 13:54:34 IST 2023
  2023-01-06 13:54:36.023[scheduling-1] c.k.s.SchedulerDemoApplication: Job Current 2 Date and Time is :Fri Jan 06 13:54:36 IST 2023
  2023-01-06 13:54:38.024[scheduling-1] c.k.s.SchedulerDemoApplication: Job Current 1 Date and Time is :Fri Jan 06 13:54:38 IST 2023

use this spring.task.sheduling.pool.size = 10 to allocate more than one thread

  2023-01-06 14:01:46.014[scheduling-1] c.k.s.SchedulerDemoApplication: Job Current 2 Date and Time is :Fri Jan 06 14:01:46 IST 2023
  2023-01-06 14:01:46.014[scheduling-2] c.k.s.SchedulerDemoApplication: Job Current 1 Date and Time is :Fri Jan 06 14:01:46 IST 2023
  2023-01-06 14:01:50.001[scheduling-1] c.k.s.SchedulerDemoApplication: Job Current 2 Date and Time is :Fri Jan 06 14:01:50 IST 2023
  2023-01-06 14:01:50.001[scheduling-3] c.k.s.SchedulerDemoApplication: Job Current 1 Date and Time is :Fri Jan 06 14:01:50 IST 2023
  2023-01-06 14:01:54.001[scheduling-4] c.k.s.SchedulerDemoApplication: Job Current 2 Date and Time is :Fri Jan 06 14:01:54 IST 2023
  2023-01-06 14:01:54.001[scheduling-2] c.k.s.SchedulerDemoApplication: Job Current 1 Date and Time is :Fri Jan 06 14:01:54 IST 2023

USECASES: create a dummy record in db for every 5 seconds and retrieve records for every 5 seconds. 
