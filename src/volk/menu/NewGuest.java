package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Numer;
import volk.util.Functions;

public class NewGuest extends AMenu {

	public NewGuest(AMenu parentMenu,Connector connect) {
		super(parentMenu,connect);
		name = "Add new \"GUEST\"";

	}

	@Override
	public void callMenu() {

		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Numer());
		List<Numer> numers = (List<Numer>) connect.receiveObject();
		for (Numer numer : numers) {
			System.out.println(numer);
		}
		Guest guest = new Guest();
		System.out.println("Enter name new guest");
		guest.setName(Functions.getString());
		System.out.println("Enter date input for new guest");
		guest.setDateIn(Functions.getDate());
		System.out.println("Enter date output for new guest");
		guest.setDateOut(Functions.getDate());
		System.out.println("Selected id numer for new guest");
		guest.setNumer(Functions.getInteger());
		connect.getConnect();
		connect.sendObject(INSERT);
		connect.sendObject(guest);
	}

}
