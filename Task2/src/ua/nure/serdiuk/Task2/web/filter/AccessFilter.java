package ua.nure.serdiuk.Task2.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.nure.serdiuk.Task2.db.entity.User;
import ua.nure.serdiuk.Task2.util.Path;

public class AccessFilter implements Filter {

	private Map<String, List<String>> access = new HashMap<>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AccessFilter#init");
		List<String> userAccess = Arrays.asList(filterConfig.getInitParameter("userAccess").split(" "));
		List<String> adminAccess = new ArrayList<String>(
				Arrays.asList(filterConfig.getInitParameter("adminAccess").split(" ")));
		adminAccess.addAll(userAccess);
		access.put("admin", adminAccess);
		access.put("user", userAccess);
		access.put("common", Arrays.asList(filterConfig.getInitParameter("commonAccess").split(" ")));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AccessFilter#doFilter");

		String command = request.getParameter("command");
		if (isAccessAllowed(request, command)) {
			System.out.println(command + " access allowed");
			chain.doFilter(request, response);
		} else {
			System.out.println(command + " access denied");
			((HttpServletRequest)request).getRequestDispatcher(Path.COMMAND_ACCESS_DENIED_VIEW).forward(request, response);
		}

	}

	@Override
	public void destroy() {
		System.out.println("AccessFilter#destroy");
	}

	private boolean isAccessAllowed(ServletRequest request, String command) {
		if (command == null || command.isEmpty()) {
			return false;
		}

		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session == null) {
			return false;
		}
		User user = (User) session.getAttribute("user");
		if (user == null && access.get("common").contains(command)) {
			return true;
		} else if (user == null) {
			return false;
		}
		String role = user.getRole();
		return access.get(role).contains(command) || access.get("common").contains(command);
	}

}
