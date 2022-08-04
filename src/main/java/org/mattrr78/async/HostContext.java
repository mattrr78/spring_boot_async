package org.mattrr78.async;

import org.springframework.stereotype.Component;

@Component
public class HostContext {

    private final ThreadLocal<String> hostName = new ThreadLocal<>();

    public String getHostName() {
        return hostName.get();
    }

    public void setHostName(String hostName) {
        this.hostName.set(hostName);
    }

}
