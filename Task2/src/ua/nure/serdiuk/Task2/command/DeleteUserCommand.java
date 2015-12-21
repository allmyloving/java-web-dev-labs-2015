package ua.nure.serdiuk.Task2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdiuk.Task2.db.DbManager;
import ua.nure.serdiuk.Task2.db.entity.User;
import ua.nure.serdiuk.Task2.util.Path;

public class DeleteUserCommand extends Command {

	private static final Logger LOG = Logger.getLogger(DeleteUserCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userLogin = req.getParameter("userLogin");
		String path = Path.COMMAND_ADMIN_VIEW;

		User user = DbManager.getUser(userLogin);

		LOG.debug("User to delete found ==> " + user);
		if (DbManager.getUsers().remove(user)) {
			LOG.info(String.format("User with login=%s was deleted.", userLogin));
		}

		if (user != null && user.getLogin().equals(((User) req.getSession().getAttribute("user")).getLogin())) {
			LOG.info("You've deleted yourself.");
			path = Path.COMMAND_LOGOUT;
		}
		return path;
	}

}
