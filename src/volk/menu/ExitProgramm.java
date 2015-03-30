package volk.menu;

import volk.client.Connector;

public class ExitProgramm extends AMenu {

	public ExitProgramm(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Exit programm";
	}

	public void callMenu() {
		connect.sendObject(new Integer(0));
		System.out.println("Close programm. Good bye.");
		System.exit(0);
	}
}
