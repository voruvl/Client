package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Service;
import volk.domain.ServiceInGuest;
import volk.query.QueryGuest;
import volk.query.QueryServiceInGuest;
import volk.util.Functions;

public class ServicesInGuest extends AMenu {

	public ServicesInGuest(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View guest services";

	}

	@Override
	public void callMenu() {

		Guest guest = new QueryGuest(connect).getGuest();

		List<ServiceInGuest> services = new QueryServiceInGuest(connect).getListServiceInGuests(guest);
		
		for (ServiceInGuest serviceInGuest : services) {
			System.out.println(serviceInGuest.getIdService());
		}
		Guest guestFind = new Guest();
		// guestFind.setId(idGuest);
		connect.getConnect();
		connect.sendObject(SELECTPK);
		connect.sendObject(guestFind);
		guestFind = (Guest) connect.receiveObject();

		System.out.println("List services in guest " + guestFind.getName()
				+ " from numer " + guestFind.getNumer());
		int summa = 0;
		for (ServiceInGuest service : services) {
			connect.getConnect();
			connect.sendObject(SELECTPK);
			Service serviceTemp = new Service();
			// serviceTemp.setId(service.getIdService());
			connect.sendObject(serviceTemp);
			Service serviceFind = (Service) connect.receiveObject();
			String nameservice = serviceFind.getNameService();
			while (nameservice.length() < 10)
				nameservice += " ";
			System.out.println("\t" + nameservice + "\t"
					+ serviceFind.getPrice());
			summa += serviceFind.getPrice();
		}
		System.out.println("\t------------------------------------");
		System.out.println("\tThe total price of services " + summa + " BLR");
	}
}
