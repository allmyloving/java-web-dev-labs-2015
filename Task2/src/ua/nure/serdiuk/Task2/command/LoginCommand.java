package ua.nure.serdiuk.Task2.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.serdiuk.Task2.db.DbManager;
import ua.nure.serdiuk.Task2.db.entity.User;
import ua.nure.serdiuk.Task2.util.Path;

public class LoginCommand extends Command {

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		List<String> errors = new ArrayList<>();

		User user = DbManager.getUser(login);
		//System.out.println("user found ==> " + user);

		if (user == null) {
			errors.add("User with login " + login + " was not found.");
			LOG.info("User with login " + login + " was not found.");
		} else if (user.getPassword().equals(password)) {
			LOG.info(String.format("You are now logged in as %s", user));

			session.setAttribute("user", user);

			return Path.COMMAND_ADMIN_VIEW;
		} else {
			errors.add("Wrong password for user " + login + ".");
			LOG.info("Wrong password for user " + login + ".");
		}

		session.setAttribute("errors", errors);

		return Path.COMMAND_ERROR_VIEW;
	}
}
