package ua.nure.serdiuk.Task2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdiuk.Task2.util.Path;

public class ErrorViewCommand extends Command {

	private static final Logger LOG = Logger.getLogger(ErrorViewCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		LOG.info("Error ==> " + req.getSession().getAttribute("errors"));
		
		return Path.VIEW_ERROR;
	}

}
