package ua.nure.serdiuk.Task2.command;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.serdiuk.Task2.util.Path;

public class NoCommand extends Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("errors", Arrays.asList("Command not found."));
		return Path.VIEW_ERROR;
	}

}
