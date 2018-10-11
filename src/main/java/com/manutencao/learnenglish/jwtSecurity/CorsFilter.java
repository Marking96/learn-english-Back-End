/**
 * 
 */
package com.manutencao.learnenglish.jwtSecurity;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */
@Component
public class CorsFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletResponse response = (HttpServletResponse) res;
		 HttpServletRequest request = (HttpServletRequest) req;
	        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
	        response.setHeader("Access-Control-Allow-Methods", "*");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        response.setHeader("Access-Control-Allow-Headers", "*");
	        //response.setHeader("Access-Control-Expose-Headers","yourCustomHeaderIfExist");

	       
	            chain.doFilter(req, res);
	        
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
