package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.query.QueryGuest;

public class ViewGuests extends AMenu {

	public ViewGuests(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View all guests";

	}

	@Override
	public void callMenu() {
		
		List<Guest> guests = new QueryGuest(connect).getListGuests();
		for (Guest guest : guests) {
			System.out.println(guest);
		}
	}
}
