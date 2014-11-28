package com.tinyIdea.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginFilter implements Filter{
    private String redirectUrl;;
    
    private List<String> whiteList;
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();
        System.out.println("URL:" + url);
        if(isWhite(url)){
            filterChain.doFilter(request, response);
            return;
        }
        
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession session = httpRequest.getSession();
        Object userId = session.getAttribute("userId");
        if(null == userId){
            httpResponse.sendRedirect(redirectUrl);
            return;
        }
        
        filterChain.doFilter(request, response);
    }
    
    private boolean isWhite(String url){
        for(String str : this.whiteList){
            if(url.contains(str)){
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.redirectUrl = filterConfig.getInitParameter("redirectUrl");
        
        String whiteList = filterConfig.getInitParameter("whiteList");
        this.whiteList = new ArrayList<String>();
        for(String url : whiteList.split(",")){
            this.whiteList.add(url);
        }
    }

}
