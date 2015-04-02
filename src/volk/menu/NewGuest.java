package volk.menu;

import volk.client.Connector;
import volk.domain.Guest;
import volk.query.QueryGuest;
import volk.query.QueryNumer;
import volk.util.Functions;

public class NewGuest extends AMenu {

	public NewGuest(AMenu parentMenu,Connector connect) {
		super(parentMenu,connect);
		name = "Add new \"GUEST\"";

	}

	@Override
	public void callMenu() {

		Guest guest = new Guest();
		System.out.println("Enter name new guest");
		guest.setName(Functions.getString());
		System.out.println("Enter date input for new guest");
		guest.setDateIn(Functions.getDate());
		System.out.println("Enter date output for new guest");
		guest.setDateOut(Functions.getDate());
		System.out.println("Selected id numer for new guest");
		guest.setNumer(new QueryNumer(connect).getNumer());
		new QueryGuest(connect).insertGuest(guest);
	}

}
