package ua.nure.serdiuk.Task2.web;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.serdiuk.Task2.util.Path;

public class LocaleServlet extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(LocaleServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String locale = req.getParameter("newLocale");
		HttpSession session = req.getSession();
		session.setAttribute("currentLocale", locale);
		try {
			LOG.info("resource bundle ==> "
					+ ResourceBundle.getBundle("resources", new Locale(locale)));
		} catch (MissingResourceException e) {
			LOG.fatal("Resource not found." + "\n" + e.getMessage());
		}

		req.getRequestDispatcher(Path.COMMAND_LOGIN_VIEW).forward(req, resp);

		// req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String locale = req.getParameter("newLocale");
		HttpSession session = req.getSession();
		session.setAttribute("currentLocale", locale);

		// req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		resp.sendRedirect(req.getContextPath() + Path.COMMAND_LOGIN_VIEW);

	}

}
