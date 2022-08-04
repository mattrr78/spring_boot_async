package org.mattrr78.async;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AsyncTaskDecorator implements TaskDecorator {

    final HostContext hostContext;

    final UserContext userContext;

    public AsyncTaskDecorator(HostContext hostContext, UserContext userContext) {
        this.hostContext = hostContext;
        this.userContext = userContext;
    }

    @Override
    public Runnable decorate(Runnable runnable) {
        final String hostName = hostContext.getHostName();
        final String userName = userContext.getUserName();
        final Map<String, String> contextMap = MDC.getCopyOfContextMap();

        return new Runnable() {
            @Override
            public void run() {
                try {
                    // MDC's contextMap could be null.
                    if (contextMap != null) {
                        MDC.setContextMap(contextMap);
                    }

                    hostContext.setHostName(hostName);
                    userContext.setUserName(userName);
                    runnable.run();
                } finally {
                    MDC.clear();
                }
            }
        };
    }

}
