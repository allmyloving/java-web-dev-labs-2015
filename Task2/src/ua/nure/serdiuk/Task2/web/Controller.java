package ua.nure.serdiuk.Task2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		LOG.trace("======COOKIES====");
		for (Cookie cookie : ((HttpServletRequest)req).getCookies()) {
			LOG.trace(cookie.getName() + " ==> " + cookie.getValue());
		}
		LOG.trace("======COOKIES====");

		String command = req.getParameter("command");
		String path = CommandContainer.getCommand(command).execute(req, resp);

		LOG.debug("Executing command " + command);
		//resp.sendRedirect("http://google.com");
		
		if (method.equals("post")) {
			LOG.debug("Redirecting to " + path);
			resp.sendRedirect(req.getContextPath() + path);
		} else {
			LOG.debug("Forward to " + path);
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}

}
