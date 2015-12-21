package ua.nure.serdiuk.Task2.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.serdiuk.Task2.util.Path;

public class LogoutCommand extends Command {
	
	private static final Logger LOG = Logger.getLogger(LogoutCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		session.setAttribute("errors", null);
		LOG.info("Current user invalidated.");

		return Path.COMMAND_LOGIN_VIEW;
	}

}
