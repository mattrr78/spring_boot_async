package org.mattrr78.noasync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoggingController {

    final HostContext hostContext;

    final UserContext userContext;

    final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    public LoggingController(HostContext hostContext, UserContext userContext) {
        this.hostContext = hostContext;
        this.userContext = userContext;
    }

    @PutMapping
    ResponseEntity<Boolean> log() {
        logger.info("Short processing completed by " + hostContext.getHostName() + ": " + userContext.getUserName());
        return ResponseEntity.ok(true);
    }

}
