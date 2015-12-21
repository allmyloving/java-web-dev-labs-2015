package ua.nure.serdiuk.Task2.command;

import java.util.HashMap;
import java.util.Map;


public class CommandContainer {
	
	private static Map<String, Command> commands = new HashMap<>();

	static {
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		
		commands.put("editUser", new EditUserCommand());
		commands.put("deleteUser", new DeleteUserCommand());
		commands.put("adminView", new AdminViewCommand());
		commands.put("editUserView", new EditUserViewCommand());
		commands.put("addUserView", new AddUserViewCommand());
		
		commands.put("loginView", new ViewLoginCommand());
		commands.put("accessDeniedView", new AccessDeniedView());
		
		commands.put("errorView", new ErrorViewCommand());
		
		commands.put("noCommand", new NoCommand());
	}
	
	public static Command getCommand(String name){
		if(commands.containsKey(name)){
			return commands.get(name);
		}
		System.out.println("Command not found ==> " + name);
		return commands.get("noCommand");
	}

}
