package ua.nure.serdiuk.Task2.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class EncodingFilter implements Filter {
	
	private static final Logger LOG = Logger.getLogger(EncodingFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOG.info("Encoding set");
		request.setCharacterEncoding("utf-8");
		
		LOG.trace("======COOKIES====");
		for (Cookie cookie : ((HttpServletRequest)request).getCookies()) {
			LOG.trace(cookie.getName() + " ==> " + cookie.getValue());
		}
		LOG.trace("======COOKIES====");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
