package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.util.Functions;


public class DeleteGuest extends AMenu {

	public DeleteGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu,connect);
		name = "Delete \"GUEST\"";
		
	}
	public void callMenu() {
		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Guest());
		List<Guest> guests = (List<Guest>) connect.receiveObject();

		for (Guest guest : guests) {
			System.out.println(guest);
		}
		Guest guest = new Guest();
		System.out.println("Enter guest id");
		guest.setId(Functions.getInteger());
		
		connect.getConnect();
		connect.sendObject(DELETE);
		connect.sendObject(guest);

	}
}
