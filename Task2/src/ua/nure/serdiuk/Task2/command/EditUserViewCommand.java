package ua.nure.serdiuk.Task2.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.serdiuk.Task2.db.DbManager;
import ua.nure.serdiuk.Task2.db.entity.User;
import ua.nure.serdiuk.Task2.util.Path;

public class EditUserViewCommand extends Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userLogin = req.getParameter("userLogin");
		HttpSession session = req.getSession();
		if (userLogin == null || userLogin.isEmpty()) {
			session.setAttribute("errors", Arrays.asList("Wrong command. User login was not specified."));
			return Path.COMMAND_ERROR_VIEW;
		}
		User currentUser = DbManager.getUser(userLogin);

		if (currentUser == null) {
			session.setAttribute("errors", Arrays.asList("User with this login was not find."));
			return Path.COMMAND_ERROR_VIEW;
		}
		session.setAttribute("currentUser", currentUser);

		System.out.println("Current user ==> " + currentUser);

		return Path.VIEW_EDIT_USER;
	}

}
