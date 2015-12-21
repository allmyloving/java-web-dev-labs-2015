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
import ua.nure.serdiuk.Task2.util.Regex;

public class EditUserCommand extends Command {

	private static final Logger LOG = Logger.getLogger(EditUserCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		HttpSession session = req.getSession();

		List<String> errors = new ArrayList<>();

		User user = (User) req.getAttribute("currentUser");
		LOG.debug("current user ==> " + user);
		if (user != null) {
			login = user.getLogin();

		}
		// validation
		if (!password.matches(Regex.PASSWORD)) {
			errors.add("Password is not valid.");
		}
		if (fullName == null || fullName.isEmpty()) {
			errors.add("Full name is not valid.");
		}
		if (!email.matches(Regex.EMAIL)) {
			errors.add("Email is not valid.");
		}

		if ((user = DbManager.getUser(login)) != null) {
			String info = String.format("Updating user with login=%s", login);
			LOG.info(info);

			user.setEmail(email);
			user.setFullName(fullName);
			user.setPassword(password);
		} else {
			user = new User(login, password, email, fullName, "user");
			DbManager.addUser(user);
			LOG.info(String.format("Adding new user %s", user));
		}

		if (errors.size() != 0) {
			//req.setAttribute("errors", errors);
			session.setAttribute("errors", errors);
			return Path.COMMAND_ERROR_VIEW;
		}

		return Path.COMMAND_ADMIN_VIEW;
	}
}
