package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Numer;
import volk.query.QueryGuest;
import volk.query.QueryNumer;

public class ViewNotEmptyNumbers extends AMenu {
	public ViewNotEmptyNumbers(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View not empty numers";

	}

	@Override
	public void callMenu() {
		
		List<Numer> numers = new QueryNumer(connect).getListNumers();
		List<Guest> guests = new QueryGuest(connect).getListGuests();

		for (int i = 0; i < numers.size(); i++) {
			for (int j = 0; j < guests.size(); j++) {
				if (guests.get(j).getNumer().getId() == numers.get(i).getId()) {
					System.out.print(numers.get(i) + " state " + "\n");
					break;
				}
			}
		}
	}
}
