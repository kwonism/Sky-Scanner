package com.proto.action;

import com.proto.aircontroller.AirSaveAction;
import com.proto.aircontroller.AirViewAction;

public class ActionFactory {
	private static String naming = "ActionFactory : ";
	
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		if(cmd.equals("air_view")) {
			return new AirViewAction();
		} else if(cmd.equals("air_save")) {
			return new AirSaveAction();
		}
		return null;
	}
}
