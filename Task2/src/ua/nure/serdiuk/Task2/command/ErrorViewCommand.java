package ua.nure.serdiuk.Task2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.serdiuk.Task2.util.Path;

public class ErrorViewCommand extends Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		return Path.VIEW_ERROR;
	}

}
