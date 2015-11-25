package ua.nure.serdiuk.Task2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.serdiuk.Task2.command.CommandContainer;

public class Controller extends HttpServlet {
	
	private static final Logger LOG = Logger.getLogger(Controller.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		process(req, resp, "get");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		process(req, resp, "post");
	}

	private void process(HttpServletRequest req, HttpServletResponse resp, String method)
			throws IOException, ServletException {
		String command = req.getParameter("command");
		String path = CommandContainer.getCommand(command).execute(req, resp);
		
		LOG.info("Executing command " + command);
		LOG.info("Redirecting to " + path);

		if (method.equals("post")) {
			resp.sendRedirect(req.getContextPath() + path);
		} else {
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}

}
