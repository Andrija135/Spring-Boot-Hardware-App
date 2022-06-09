package hr.tvz.poljak.hardwareapp.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail availableHardwareJobDetail() {

        return JobBuilder
                .newJob(AvailableHardwareJob.class)
                .withIdentity("availableHardwareJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger AvailableHardwareTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(10)
                .repeatForever();

        return TriggerBuilder
                .newTrigger()
                .forJob(availableHardwareJobDetail())
                .withIdentity("availableHardwareTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
