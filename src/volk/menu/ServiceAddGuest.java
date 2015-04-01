package volk.menu;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Service;
import volk.domain.ServiceInGuest;
import volk.query.QueryGuest;
import volk.query.QueryService;

public class ServiceAddGuest extends AMenu {

	public ServiceAddGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Add service for GUEST";

	}

	@Override
	public void callMenu() {

		ServiceInGuest servInGuest = new ServiceInGuest();
		System.out.println("Entering id guest for inserting service");
		Guest guest = new QueryGuest(connect).getGuest();
		servInGuest.setIdGuest(guest);
		Service service = new QueryService(connect).getService();
		servInGuest.setIdService(service);
		connect.getConnect();
		connect.sendObject(INSERT);
		connect.sendObject(servInGuest);
	}
}
