package com.forum.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.forum.constants.ConstPageLocation;


@WebFilter("/LocationFilter")
public class LocationFilter implements Filter {
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		String uri = ((HttpServletRequest) request).getRequestURI();

		if(isIndexView(uri)) {
			request.setAttribute("location", ConstPageLocation.HOME);
		}
		if(isRegisterView(uri)) {
			request.setAttribute("location", ConstPageLocation.REGISTER);
		}
		
		chain.doFilter(request, response);
	}
	
	private boolean isIndexView(String uri) {
		return uri.indexOf("index.do") != -1 || 
				uri.indexOf("loginAndOut.do") != -1;
	}
	
	private boolean isRegisterView(String uri) {
		return uri.indexOf("register.do") != -1;
	}

	@Override
	public void destroy() {
		
	}

}
