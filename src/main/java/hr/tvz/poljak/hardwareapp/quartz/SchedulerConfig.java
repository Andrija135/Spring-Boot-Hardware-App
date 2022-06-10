package hr.tvz.poljak.hardwareapp.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

import static org.quartz.TriggerBuilder.newTrigger;

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
    public Trigger availableHardwareTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(10)
                .repeatForever();

        return newTrigger()
                .forJob(availableHardwareJobDetail())
                .withIdentity("availableHardwareTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public Trigger availableHardwareEveryMonAndFriTrigger() {
        Set<Integer> daysOfWeek = new HashSet<>();
        daysOfWeek.add(DayOfWeek.MONDAY.getValue() + 1);
        daysOfWeek.add(DayOfWeek.FRIDAY.getValue() + 1);

        DailyTimeIntervalScheduleBuilder dailyTimeIntervalScheduleBuilder = DailyTimeIntervalScheduleBuilder
                .dailyTimeIntervalSchedule()
                .onDaysOfTheWeek(daysOfWeek)
                .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(12, 12));

        return newTrigger()
                .forJob(availableHardwareJobDetail())
                .withIdentity("availableHardwareTriggerEveryMonAndFri")
                .withSchedule(dailyTimeIntervalScheduleBuilder)
                .build();
    }


}
