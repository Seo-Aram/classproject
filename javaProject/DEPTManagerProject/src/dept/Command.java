package dept;

import java.util.HashMap;
import java.util.Map;

import dept.controller.Controller;
import dept.controller.InsertController;
import dept.controller.SelectController;

public class Command {
	public Map<Integer, Controller> command;
	
	public Command() {
		command = new HashMap<>();
		command.put(1, new SelectController());
		command.put(3, new InsertController());
	}
}
