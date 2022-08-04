package org.mattrr78.wrongasync;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class HostFilter extends GenericFilterBean {

    final HostContext hostContext;

    public HostFilter(HostContext hostContext) {
        this.hostContext = hostContext;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String hostName = request.getServerName();

        hostContext.setHostName(hostName);

        MDC.put("hostName", hostName);

        chain.doFilter(request, response);
    }

}
