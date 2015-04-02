package volk.menu;

import volk.client.Connector;

public class MenuNumer extends AMenu {

	public MenuNumer(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Menu Numers";
	}

	@Override
	public void callMenu() {
		getName();
	}

}
