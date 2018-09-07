package com.anatoliivoloshyn.cinemawebapp.filter;

import javax.servlet.*;
import java.io.IOException;
/**
 * Filter class that sets encoding on every request and response to UTF-8
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request,response);
    }
}
