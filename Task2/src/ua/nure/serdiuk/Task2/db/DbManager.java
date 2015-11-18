package ua.nure.serdiuk.Task2.db;

import java.util.ArrayList;
import java.util.List;

import ua.nure.serdiuk.Task2.db.entity.User;

public class DbManager {

	private static List<User> users;

	static {
		users = new ArrayList<>();
		users.add(new User("daria", "password", "daria@gmail.com", "daria", "admin"));
		users.add(new User("ann", "password", "ann@gmail.com", "ann", "user"));
		users.add(new User("alex", "password", "alex@gmail.com", "alex", "user"));
	}

	public static User getUser(String login) {
		for (User user : users) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
		return null;
	}

	public static boolean checkUser(String login, String password) {
		for (User user : users) {
			if (user.getLogin().equals(login)) {
				return user.getPassword().equals(password);
			}
		}
		return false;
	}
	
	public static void addUser(User user){
		users.add(user);
	}

	public static List<User> getUsers() {
		return users;
	}
}
