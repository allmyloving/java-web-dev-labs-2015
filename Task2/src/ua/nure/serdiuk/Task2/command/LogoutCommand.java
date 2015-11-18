package ua.nure.serdiuk.Task2.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.serdiuk.Task2.util.Path;

public class LogoutCommand extends Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate();
		System.out.println("Session invalidated.");

		return Path.VIEW_LOGIN;
	}

}
