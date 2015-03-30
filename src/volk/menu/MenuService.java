package volk.menu;

import volk.client.Connector;

public class MenuService extends AMenu {

	public MenuService(AMenu parentMenu,Connector connect) {
		super(parentMenu,connect);
		name="Menu Services";
	}

	@Override
	public void callMenu() {
		getName();
	}

}
