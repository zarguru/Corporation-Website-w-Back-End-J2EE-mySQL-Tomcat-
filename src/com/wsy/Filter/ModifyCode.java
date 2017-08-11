package com.wsy.Filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ModifyCode implements Filter{
	protected FilterConfig filterConfig;
	private String targetEncoding="UTF-8";
	public void init(FilterConfig config)throws ServletException{
		this.filterConfig=config;
		this.targetEncoding=config.getInitParameter("code");
	}
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws ServletException{
		//System.out.println("Use the following method to encode"+this.targetEncoding);
		HttpServletRequest srequest=(HttpServletRequest)request;
		try{
			srequest.setCharacterEncoding(this.targetEncoding);
			chain.doFilter(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void destroy(){
		this.filterConfig=null;
	}
}
