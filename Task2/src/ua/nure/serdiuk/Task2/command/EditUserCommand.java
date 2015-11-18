package ua.nure.serdiuk.Task2.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.serdiuk.Task2.db.DbManager;
import ua.nure.serdiuk.Task2.db.entity.User;
import ua.nure.serdiuk.Task2.util.Path;
import ua.nure.serdiuk.Task2.util.Regex;

public class EditUserCommand extends Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		
		List<String> errors = new ArrayList<>();

		User user = (User) req.getSession().getAttribute("currentUser");

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

		if (user == null) {
			user = new User(login, password, email, fullName, "user");
			if (DbManager.getUser(login) != null) {
				errors.add("User with login + " + login + " already exists.");
			} else {
				DbManager.addUser(user);
			}
		} else {
			user.setEmail(email);
			user.setFullName(fullName);
			user.setPassword(password);
		}

		if (errors.size() != 0) {
			HttpSession session = req.getSession();
			session.setAttribute("errors", errors);
			return Path.COMMAND_ERROR_VIEW;
		}

		return Path.COMMAND_ADMIN_VIEW;
	}

}
