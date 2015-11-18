package ua.nure.serdiuk.Task1;

import java.io.IOException;

import javax.naming.OperationNotSupportedException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 2586469175212122874L;

	private static final Logger LOG = Logger.getLogger(MyServlet.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder errors = new StringBuilder();
		String operation = req.getParameter("operation");
		String var1AsString = req.getParameter("var1");
		String var2AsString = req.getParameter("var2");

		double var1 = 0;
		double var2 = 0;
		double result = 0;

		try {
			var1 = Double.parseDouble(var1AsString);
			var2 = Double.parseDouble(var2AsString);

		} catch (NumberFormatException | NullPointerException e) {
			errors.append("Input data is incorrect (fill all the fields, numbers only).")
					.append(System.lineSeparator());
		}
		switch (operation) {
		case "add":
			result = var1 + var2;
			break;
		case "sub":
			result = var1 - var2;
			break;
		case "mul":
			result = var1 * var2;
			break;
		case "div":
			if (var2 != 0) {
				result = var1 / var2;
			} else {
				errors.append("Dividing by zero is not allowed.").append(System.lineSeparator());
			}
			break;
		default:
			errors.append("Operation is incorrect or not supported.").append(System.lineSeparator());
		}

		if (errors.length() == 0) {
			req.setAttribute("result", "Result: " + result);
		} else {
			req.setAttribute("errors", errors);
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
