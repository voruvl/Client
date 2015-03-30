package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Service;

public class ViewServices extends AMenu {

	public ViewServices(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View all \"SERVICES\"";

	}

	@Override
	public void callMenu() {

		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Service());
		List<Service> services = (List<Service>) connect.receiveObject();
		for (Service service : services) {
			System.out.println(service);
		}
	}
}
