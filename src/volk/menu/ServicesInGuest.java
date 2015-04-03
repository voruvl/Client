package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.ServiceInGuest;
import volk.query.QueryServiceInGuest;

public class ServicesInGuest extends AMenu {

	public ServicesInGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View guest services";

	}

	@Override
	public void callMenu() {
		List<ServiceInGuest> serviceInGuests = new QueryServiceInGuest(connect)
				.getListServiceInGuests();
		System.out.println("List services inner guest");
		for (ServiceInGuest serviceInGuest : serviceInGuests) {
			System.out.println(serviceInGuest);
		}
	}
}