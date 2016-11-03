package com.imarce.webadmin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
    public LoginFilter() {
    }
	public void destroy() {
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String noFilter=new String("login.html");
		String uri = req.getRequestURI();  
		String path=req.getContextPath();
		Object user=req.getSession().getAttribute("user");
		if(isPass(uri)){
			chain.doFilter(request, response);
		}else{
			if(user==null){
				res.sendRedirect(path+"/login/"+noFilter);
			}else{
				chain.doFilter(request, response);
			}
		}
	}
	
	
	public boolean isPass(String uri){
		if(uri.endsWith(".css")||uri.endsWith(".js")||uri.endsWith(".jpg")
				||uri.endsWith(".png")||uri.endsWith(".bmp")||uri.endsWith(".dib")
				||uri.endsWith(".rle")||uri.endsWith(".emf")||uri.endsWith(".gif")
				||uri.endsWith(".jpeg")||uri.endsWith(".jpe")||uri.endsWith(".jif")
				||uri.endsWith(".pcx")||uri.endsWith(".dcx")||uri.endsWith(".pic")
				||uri.endsWith(".tga")||uri.endsWith(".tif")||uri.endsWith(".tiffxif")
				||uri.endsWith(".wmf")||uri.endsWith(".jfif")
				||uri.endsWith("login.html")||uri.endsWith("login_user")
				||uri.endsWith("register_user")){
			return true;
		}else{
			return false;
		}
	}

	                


}
