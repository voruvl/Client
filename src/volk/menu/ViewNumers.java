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
			connect.getConnect();
			connect.sendObject(new Integer(SELECTPK));
			StateNumer state=new StateNumer();
			state.setId(numer.getState());
			connect.sendObject(state);
			System.out.println(numer+" State " +((StateNumer)connect.receiveObject()).getNameState());
		}
	}
}
