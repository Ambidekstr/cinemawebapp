package com.anatoliivoloshyn.cinemawebapp.filter;

import com.anatoliivoloshyn.cinemawebapp.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Filter class that resolves access of users to admin pages
 */
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = (User) request.getSession().getAttribute("user");
        if(request.getParameter("command")!=null) {
            if (request.getParameter("command").equals("deleteSession")
                    || request.getParameter("command").equals("addNewSession")
                    || request.getParameter("command").equals("addSession")) {
                if (user != null && user.getRole().getRoleId()==1L) {
                    filterChain.doFilter(request, response);
                }else {
                    response.sendRedirect("/error.jsp");
                    return;
                }
            }else{
                filterChain.doFilter(request,response);
                return;
            }
        }else {
            filterChain.doFilter(request, response);
        }
    }
}
