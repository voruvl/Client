package volk.menu;

import volk.client.Connector;
import volk.domain.Service;
import volk.query.QueryService;
import volk.util.Functions;

public class NewService extends AMenu {

	public NewService(AMenu parentMenu, Connector connect) {
		super(parentMenu,connect);
		name = "Add new \"SERVICE\"";

	}

	@Override
	public void callMenu() {
		Service service = new Service();
		System.out.println("Enter service");
		service.setNameService(Functions.getString());
		System.out.println("Enter price");
		service.setPrice(Functions.getInteger());
		new QueryService(connect).insertService(service);
	}

}
