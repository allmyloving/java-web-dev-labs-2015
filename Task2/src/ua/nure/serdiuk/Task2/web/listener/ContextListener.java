package ua.nure.serdiuk.Task2.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.omg.CORBA.ContextList;

public class ContextListener implements ServletContextListener {
	
	private static final Logger LOG = Logger.getLogger(ContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// load log4j
		PropertyConfigurator.configure(sce.getServletContext().getRealPath("WEB-INF/log4j.properties"));
		LOG.info("log4j configured.");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
