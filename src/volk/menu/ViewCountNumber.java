package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Numer;

public class ViewCountNumber extends AMenu {

	public ViewCountNumber(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View count numers";

	}

	@Override
	public void callMenu() {

		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Numer());
		List<Numer> numers = (List<Numer>) connect.receiveObject();
		System.out.println("Count all numers in hotel " + numers.size());
		connect.closeSocket();
	}
}
