package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Service;
import volk.domain.ServiceInGuest;
import volk.query.QueryGuest;
import volk.query.QueryService;
import volk.query.QueryServiceInGuest;

public class DeleteServiceFromGuest extends AMenu {

	public DeleteServiceFromGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Delete service from guest";

	}

	@Override
	public void callMenu() {
		
		Guest guest = new QueryGuest(connect).getGuest();
		List<ServiceInGuest> serviceInGuests = new QueryServiceInGuest(connect)
				.getListServiceInGuests(guest);
		System.out.println("List services inner guest");
		
		for (ServiceInGuest serviceInGuest : serviceInGuests) {
			System.out.println(serviceInGuest);
			
		}

		ServiceInGuest servInGuest = new ServiceInGuest();
		servInGuest.setIdGuest(guest);
		Service service=new QueryService(connect).getService();
		servInGuest.setIdService(service);
		servInGuest=new QueryServiceInGuest(connect).getListServiceInGuests(servInGuest);
		
		new QueryServiceInGuest(connect).deleteServiceInGuests(servInGuest);
	}
}