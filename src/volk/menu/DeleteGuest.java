package volk.menu;

import volk.client.Connector;
import volk.domain.Guest;
import volk.query.QueryGuest;


public class DeleteGuest extends AMenu {

	public DeleteGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu,connect);
		name = "Delete \"GUEST\"";
		
	}
	public void callMenu() {
		
		Guest guest = new QueryGuest(connect).getGuest();
		new QueryGuest(connect).deleteGuest(guest);

	}
}
