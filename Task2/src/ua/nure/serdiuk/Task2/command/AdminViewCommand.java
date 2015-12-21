package ua.nure.serdiuk.Task2.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdiuk.Task2.db.DbManager;
import ua.nure.serdiuk.Task2.db.entity.User;
import ua.nure.serdiuk.Task2.util.Path;

public class AdminViewCommand extends Command {

	private static Logger LOG = Logger.getLogger(AdminViewCommand.class);

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String delete = req.getParameter("delete");
		String deleteMode = req.getParameter("deleteMode");
		String userLogin = req.getParameter("userLogin");
		String path = Path.VIEW_ADMIN;

		req.setAttribute("deleteMode", deleteMode);
		req.setAttribute("userLogin", userLogin);

		if (delete != null && !delete.isEmpty() && Boolean.valueOf(delete)) {
			User user = DbManager.getUser(userLogin);

			LOG.debug("User found ==> " + user);
			if (DbManager.getUsers().remove(user)) {
				resp.sendRedirect(Path.COMMAND_ADMIN_VIEW);
			}

			if (user != null && user.getLogin().equals(((User) req.getSession().getAttribute("user")).getLogin())) {
				LOG.info("You've deleted yourself.");
				path = Path.COMMAND_LOGOUT;
			}
		}

		List<User> list = DbManager.getUsers();
		req.setAttribute("users", list);
		return path;
	}

}
