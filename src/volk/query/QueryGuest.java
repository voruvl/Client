package volk.query;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.util.Functions;

public class QueryGuest extends AQuery {

	public QueryGuest(Connector connect) {
		super(connect);

	}

	public Guest getGuest() {
		Guest guest = new Guest();
		for (Guest guestList : getListGuests()) {
			System.out.println(guestList);
		}
		System.out.println("Select id guest");

		guest.setId(Functions.getInteger());
		connect.getConnect();
		connect.sendObject(SELECTPK);
		connect.sendObject(guest);
		guest = (Guest) connect.receiveObject();
		return guest;
	}

	public List<Guest> getListGuests() {
		connect.getConnect();
		connect.sendObject(SELECT);
		connect.sendObject(new Guest());
		return (List<Guest>) connect.receiveObject();
	}
}
