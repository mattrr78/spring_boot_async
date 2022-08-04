package org.mattrr78.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    final HostContext hostContext;

    final UserContext userContext;

    final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public LoggingService(HostContext hostContext, UserContext userContext) {
        this.hostContext = hostContext;
        this.userContext = userContext;
    }

    @Async
    public void log() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        logger.info("Long running task completed by " + hostContext.getHostName() + ": " + userContext.getUserName());
    }

}
