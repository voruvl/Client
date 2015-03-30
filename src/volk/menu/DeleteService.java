package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Service;
import volk.util.Functions;

public class DeleteService extends AMenu {

	public DeleteService(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Delete \"SERVICE\"";

	}

	@Override
	public void callMenu() {
		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Service());
		List<Service> services = (List<Service>) connect.receiveObject();
		for (Service service : services) {
			System.out.println(service);
		}
		connect.getConnect();
		Service service = new Service();
		System.out.println("Enter service id");
		service.setId(Functions.getInteger());
		connect.sendObject(DELETE);
		connect.sendObject(service);
	}
}
