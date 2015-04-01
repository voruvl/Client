package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Numer;
import volk.query.QueryNumer;

public class ViewNumers extends AMenu {

	public ViewNumers(AMenu parentMenu, Connector connect) {
		super(parentMenu,connect);
		name = "View all numers";

	}

	@Override
	public void callMenu() {
		List<Numer> numers = new QueryNumer(connect).getListNumers();
		for (Numer numer : numers) {
			System.out.println(numer);
		}
	}
}
