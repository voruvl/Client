package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Numer;
import volk.util.Functions;

public class CloningNumber extends AMenu {

	public CloningNumber(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Cloning number";

	}

	@Override
	public void callMenu() {
		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Numer());
		List<Numer> numers = (List<Numer>) connect.receiveObject();
		for (Numer numer : numers) {
			System.out.println(numer);
		}
		Numer numerNew = new Numer();
		System.out.println("Select id numer  for cloning ");
		numerNew.setId(Functions.getInteger());
		System.out.println("Enter count cloning");
		int count = Functions.getInteger();

		connect.getConnect();
		connect.sendObject(SELECTPK);
		connect.sendObject(numerNew);
		numerNew=(Numer)connect.receiveObject();
		for (int i = 0; i < count; i++) {
			connect.getConnect();
			connect.sendObject(INSERT);
			connect.sendObject(numerNew);
		}
	}
}