package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Service;
import volk.domain.ServiceInGuest;
import volk.util.Functions;

public class ServiceAddGuest extends AMenu {

	public ServiceAddGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Add service for GUEST";

	}

	@Override
	public void callMenu() {

		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Guest());
		List<Guest> guests = (List<Guest>) connect.receiveObject();

		for (Guest guest : guests) {
			System.out.println(guest);
		}
		ServiceInGuest servInGuest = new ServiceInGuest();
		System.out.println("Entering id guest for inserting service");
		servInGuest.setIdGuest(Functions.getInteger());
		connect.getConnect();
		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Service());
		List<Service> services = (List<Service>) connect.receiveObject();
		for (Service service : services) {
			System.out.println(service);
		}
		System.out.println("Entering id  service");
		servInGuest.setIdService(Functions.getInteger());
		connect.getConnect();
		connect.sendObject(INSERT);
		connect.sendObject(servInGuest);
	}
}
