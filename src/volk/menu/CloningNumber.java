package volk.menu;

import volk.client.Connector;
import volk.domain.Numer;
import volk.query.QueryNumer;
import volk.util.Functions;

public class CloningNumber extends AMenu {

	public CloningNumber(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Cloning number";

	}

	@Override
	public void callMenu() {
		Numer numer = new QueryNumer(connect).getNumer();
		
		System.out.println("Enter count cloning numer");
		int count=Functions.getInteger();
		for (int i = 0; i < count; i++) {
			connect.getConnect();
			connect.sendObject(INSERT);
			connect.sendObject(numer);
		}
	}
}