package volk.menu;

import volk.client.Connector;

public class MenuGuest extends AMenu{

	public MenuGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name="Menu Guests";
	}

	@Override
	public void callMenu() {
		getName();
	}

}
