package org.mattrr78.async;

import org.springframework.stereotype.Component;

@Component
public class UserContext {

    private final ThreadLocal<String> userName = new ThreadLocal<>();

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

}
