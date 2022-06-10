package hr.tvz.poljak.hardwareapp.quartz;

import hr.tvz.poljak.hardwareapp.hardware.service.HardwareService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AvailableHardwareJob extends QuartzJobBean {

    @Autowired
    private HardwareService hardwareService;

    private static final Logger logger = LoggerFactory.getLogger(AvailableHardwareJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String line_divider = "----------------------------------";

        logger.info("\nOvo su trenutno dostupni hardveri:\n" + line_divider);

        this.hardwareService.findAll()
                .stream()
                .filter(item -> item.getStock() > 0)
                .forEach(item -> System.out.println(item.getName() + " - " + item.getStock()));

        System.out.println(line_divider);
    }
}
