package local.learn.carsite.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "authorization, x-auth-token, x-requested-with");
        response.setHeader("Access-Control-Max-Age", "3600");
        HttpServletRequest request = (HttpServletRequest) req;
        if (!"OPTIONS".equals(request.getMethod())) {
            chain.doFilter(req, res);
        } else {
        }
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}