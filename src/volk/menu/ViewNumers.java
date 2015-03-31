package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Numer;
import volk.domain.StateNumer;

public class ViewNumers extends AMenu {

	public ViewNumers(AMenu parentMenu, Connector connect) {
		super(parentMenu,connect);
		name = "View all numers";

	}

	@Override
	public void callMenu() {
		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Numer());
		List<Numer> numers = (List<Numer>) connect.receiveObject();
		for (Numer numer : numers) {
			System.out.println(numer);
		}
	}
}
