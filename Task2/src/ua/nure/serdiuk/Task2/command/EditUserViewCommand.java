package ua.nure.serdiuk.Task2.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdiuk.Task2.db.DbManager;
import ua.nure.serdiuk.Task2.db.entity.User;
import ua.nure.serdiuk.Task2.util.Path;

public class EditUserViewCommand extends Command {
	
	private static final Logger LOG = Logger.getLogger(EditUserViewCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userLogin = req.getParameter("userLogin");
		if (userLogin == null || userLogin.isEmpty()) {
			req.setAttribute("errors", Arrays.asList("Wrong command. User login was not specified."));
			return Path.COMMAND_ERROR_VIEW;
		}
		
		User currentUser = DbManager.getUser(userLogin);
		if (currentUser == null) {
			req.setAttribute("errors", Arrays.asList("User with this login was not found."));
			return Path.COMMAND_ERROR_VIEW;
		}
		req.setAttribute("currentUser", currentUser);

		LOG.info("Current user ==> " + currentUser);

		return Path.VIEW_EDIT_USER;
	}

}
