package volk.menu;

import volk.client.Connector;


public class MainMenu extends AMenu {

	public MainMenu(AMenu parentMenu,Connector connect) {
		super(parentMenu,connect);
		name = "Main menu";
	}

	@Override
	public void callMenu() {
		getName();
	}

	

}
