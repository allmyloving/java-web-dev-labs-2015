package ua.nure.serdiuk.Task2.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {

	public abstract String execute(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException;

}
