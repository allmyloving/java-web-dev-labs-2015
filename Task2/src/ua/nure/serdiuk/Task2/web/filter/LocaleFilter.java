package ua.nure.serdiuk.Task2.web.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LocaleFilter implements Filter {
	private static final Logger LOG = Logger.getLogger(LocaleFilter.class);

	private static String defaultLocale;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		defaultLocale = filterConfig.getInitParameter("defaultLocale");
		LOG.info("Default locale ==> " + defaultLocale);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String newLocale = request.getParameter("lang");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(true);
		List<String> locales = (List<String>) request.getServletContext().getAttribute("localeList");
		Locale locale = null;

		LOG.debug("In session ==> " + session.getAttribute("currentLocale"));

		if (newLocale != null && locales.contains(newLocale)) {
			locale = new Locale(newLocale);
			LOG.debug("Locale is set by the client ==> " + locale);
		} else if (session.getAttribute("currentLocale") == null) {
			Enumeration<Locale> locs = request.getLocales();
			while (locs.hasMoreElements()) {
				Locale reqLocale = locs.nextElement();
				if (locales.contains(reqLocale)) {
					locale = reqLocale;
					LOG.debug("Locale is set from request preferred ==> " + locale);
					break;
				}
			}
			if (locale == null) {
				locale = new Locale(defaultLocale);
				LOG.debug("Locale is set to default");
			}
		}

		if (locale != null) {
			session.setAttribute("currentLocale", locale);
			LOG.info("Locale is set to ==> " + locale);
		}
		LOG.info("Current locale ==> " + session.getAttribute("currentLocale"));

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
