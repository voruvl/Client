package volk.menu;

import volk.client.Connector;
import volk.domain.Numer;
import volk.query.QueryNumer;
import volk.query.QueryStateNumer;
import volk.util.Functions;

public class NewNumer extends AMenu {

	public NewNumer(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Add new \"NUMER\"";

	}

	@Override
	public void callMenu() {

		Numer numer = new Numer();
		System.out.println("Enter count stars");
		numer.setStars(Functions.getInteger());
		System.out.println("Enter price new numer");
		numer.setPrice(Functions.getInteger());
		System.out.println("Enter count capacity new numer");
		numer.setCapacity(Functions.getInteger());
		numer.setState(new QueryStateNumer(connect).getStateNumer());
		new QueryNumer(connect).insertNumer(numer);

	}

}
