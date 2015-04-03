package volk.query;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Numer;
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

	public void deleteGuest(Guest guest) {
		connect.getConnect();
		connect.sendObject(DELETE);
		connect.sendObject(guest);
	}

	public Guest getGuest(Numer numer) {
		Guest guestFind = null;
		for (Guest guest : getListGuests()) {
			if (guest.getNumer().getId() == (numer.getId())) {
				guestFind = guest;
			}
		}
		return guestFind;
	}

	public void deleteGuest(Numer numer) {
		for (Guest guest : getListGuests()) {
			if (guest.getNumer().getId() == (numer.getId())) {
				deleteGuest(guest);
			}
		}

	}

	public void insertGuest(Guest guest) {
		connect.getConnect();
		connect.sendObject(INSERT);
		connect.sendObject(guest);
	}
}
