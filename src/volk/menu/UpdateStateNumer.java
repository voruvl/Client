package volk.menu;

import volk.client.Connector;
import volk.domain.Numer;
import volk.query.QueryNumer;
import volk.query.QueryStateNumer;

public class UpdateStateNumer extends AMenu {

	public UpdateStateNumer(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Update state numer";

	}

	@Override
	public void callMenu() {

		Numer numer=new QueryNumer(connect).getNumer();
		if (numer != null) {
			numer.setState(new QueryStateNumer(connect).getStateNumer());
			new QueryNumer(connect).updateNumer(numer);

		} else {
			System.out.println("Entering value failed");
			System.out.println("-------------------------");
			connect.closeSocket();
		}
	}
}
