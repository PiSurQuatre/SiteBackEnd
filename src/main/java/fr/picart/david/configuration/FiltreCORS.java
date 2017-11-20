package fr.picart.david.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by pic on 20/11/2017.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FiltreCORS implements Filter {

    @Autowired
    private Environment environment;

    private String[] acao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        acao = environment.getProperty("access-control-allow-origin").split(",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        acao = environment.getProperty("access-control-allow-origin").split(",");

        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpServletRequest request = (HttpServletRequest) servletRequest;

        String origin = request.getHeader("Origin");

        response.setHeader("Access-Control-Allow-Origin", Arrays.asList(acao).contains(origin) ? origin : "");

        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Authorization, Origin, Content-Type, Version");
        response.setHeader("Access-Control-Expose-Headers", "X-Requested-With, Authorization, Origin, Content-Type");

        if (!request.getMethod().equals("OPTIONS")) {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
