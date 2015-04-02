package volk.menu;

import volk.client.Connector;
import volk.domain.Service;
import volk.query.QueryService;

public class DeleteService extends AMenu {

	public DeleteService(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Delete \"SERVICE\"";

	}

	@Override
	public void callMenu() {
		Service service=new QueryService(connect).getService();
		new QueryService(connect).deleteService(service);
	}
}
