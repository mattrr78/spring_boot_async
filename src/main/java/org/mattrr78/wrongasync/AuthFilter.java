package org.mattrr78.wrongasync;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(2)
public class AuthFilter extends GenericFilterBean {

    final UserContext userContext;

    public AuthFilter(UserContext userContext) {
        this.userContext = userContext;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authorization = ((HttpServletRequest)request).getHeader("Authorization");
        if (authorization != null) {
            String[] authData = authorization.trim().split("\\s+");
            if (authData.length == 2 && "basic".equalsIgnoreCase(authData[0])) {
                String userName = authData[1];

                userContext.setUserName(userName);

                MDC.put("userName", userName);
            }
        }
        chain.doFilter(request, response);
    }

}
