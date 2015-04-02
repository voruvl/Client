package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.ServiceInGuest;
import volk.query.QueryGuest;
import volk.query.QueryServiceInGuest;

public class ViewServicesInGuest extends AMenu {

	public ViewServicesInGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View  services in guest";

	}

	@Override
	public void callMenu() {
		Guest guest =new QueryGuest(connect).getGuest();
		
		List<ServiceInGuest> serviceInGuests = new QueryServiceInGuest(connect)
				.getListServiceInGuests(guest);
		System.out.println("List services inner guest");
		int summa=0;
		for (ServiceInGuest serviceInGuest : serviceInGuests) {
			System.out.println(serviceInGuest);
			summa=summa+serviceInGuest.getIdService().getPrice();
		}
		System.out.println("The total price of services for the visitor "+summa);
	}
}
