package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Numer;

public class ViewNotEmptyNumbers extends AMenu {
	public ViewNotEmptyNumbers(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View not empty numers";

	}

	@Override
	public void callMenu() {
		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Numer());
		List<Numer> numers = (List<Numer>) connect.receiveObject();
		connect.getConnect();
		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Guest());
		List<Guest> guests = (List<Guest>) connect.receiveObject();

		for (int i = 0; i < numers.size(); i++) {
			for (int j = 0; j < guests.size(); j++) {
				if (guests.get(j).getNumer() == numers.get(i).getId()) {
					System.out.print(numers.get(i) + " state " + "\n");
					break;
				}
			}
		}
	}
}
