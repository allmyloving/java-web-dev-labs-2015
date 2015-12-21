package ua.nure.serdiuk.Task2.web.listener;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ContextListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger(ContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();

		PropertyConfigurator.configure(context.getRealPath("WEB-INF/log4j.properties"));
		LOG.info("log4j configured.");

		String[] locales = context.getInitParameter("localeList").split("\\s+");
		context.setAttribute("localeList", Arrays.asList(locales));
		LOG.info("locales found ==> " + Arrays.asList(locales));

		String bundleBasename = context.getInitParameter("bundleBasename");
		context.setAttribute("bundleBasename", bundleBasename);
		LOG.info("bundleBasename set to ==> " + bundleBasename);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
