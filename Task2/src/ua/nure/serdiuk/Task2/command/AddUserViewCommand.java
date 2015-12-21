package ua.nure.serdiuk.Task2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.serdiuk.Task2.util.Path;

public class AddUserViewCommand extends Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setAttribute("currentUser", null);
		return Path.VIEW_EDIT_USER;
	}

}
