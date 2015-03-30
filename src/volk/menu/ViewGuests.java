package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;

public class ViewGuests extends AMenu {

	public ViewGuests(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View all guests";

	}

	@Override
	public void callMenu() {
		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Guest());
		List<Guest> guests = (List<Guest>) connect.receiveObject();
		for (Guest guest : guests) {
			System.out.println(guest);
		}
	}
}
