package volk.menu;

import volk.client.Connector;
import volk.domain.Numer;
import volk.query.QueryGuest;
import volk.query.QueryNumer;

public class DeleteNumer extends AMenu {

	public DeleteNumer(AMenu parentMenu, Connector connect) {
		super(parentMenu,connect);
		name = "Delete \"Numer\"";
		
	}
	public void callMenu() {
		
		Numer numer = new QueryNumer(connect).getNumer();
		new QueryGuest(connect).getGuest(numer);
		new QueryGuest(connect).deleteGuest(numer);
		new QueryNumer(connect).deleteNumer(numer);

	}
}
