package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Service;
import volk.query.QueryService;

public class ViewServices extends AMenu {

	public ViewServices(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View all \"SERVICES\"";

	}

	@Override
	public void callMenu() {

		List<Service> services = new QueryService(connect).getListsServices();
		for (Service service : services) {
			System.out.println(service);
		}
	}
}
