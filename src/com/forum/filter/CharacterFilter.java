package com.forum.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain filterChain) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		filterChain.doFilter(req, rep);
	}

	@Override
	public void destroy() {
		
	}

}
