package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Numer;
import volk.query.QueryNumer;

public class ViewCountNumber extends AMenu {

	public ViewCountNumber(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "View count numers";
	}

	@Override
	public void callMenu() {
		List<Numer> numers = new QueryNumer(connect).getListNumers();
		System.out.println("Count all numers in hotel " + numers.size());
	}
}
