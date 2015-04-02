package volk.menu;

import volk.client.Connector;
import volk.domain.Numer;
import volk.query.QueryNumer;

public class DeleteNumer extends AMenu {

	public DeleteNumer(AMenu parentMenu, Connector connect) {
		super(parentMenu,connect);
		name = "Delete \"Numer\"";
		
	}
	public void callMenu() {
		
		Numer numer = new QueryNumer(connect).getNumer();
		new QueryNumer(connect).deleteNumer(numer);

	}
}