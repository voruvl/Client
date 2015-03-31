package volk.menu;

import java.util.List;

import volk.client.Connector;
import volk.domain.Numer;
import volk.domain.StateNumer;
import volk.util.Functions;

public class UpdateStateNumer extends AMenu {

	public UpdateStateNumer(AMenu parentMenu, Connector connect) {
		super(parentMenu, connect);
		name = "Update state numer";

	}

	@Override
	public void callMenu() {

		connect.sendObject(new Integer(SELECT));
		connect.sendObject(new Numer());
		List<Numer> numers = (List<Numer>) connect.receiveObject();
		for (Numer numer : numers) {
			connect.getConnect();
			connect.sendObject(new Integer(SELECTPK));
			StateNumer state = new StateNumer();
//			state.setId(numer.getState());
			connect.sendObject(state);
			System.out.println(numer + " State "
					+ ((StateNumer) connect.receiveObject()).getNameState());
		}
		Numer numer = null;

		numer = new Numer();
		System.out.println("Select id numer for update state numer");
		numer.setId(Functions.getInteger());
		connect.getConnect();
		connect.sendObject(SELECTPK);
		connect.sendObject(numer);
		numer = (Numer) connect.receiveObject();
		if (numer != null) {
			connect.getConnect();
			connect.sendObject(new Integer(SELECT));
			connect.sendObject(new StateNumer());
			List<StateNumer> states = (List<StateNumer>) connect
					.receiveObject();
			System.out.println("List states for numers: ");

			for (StateNumer state : states) {
				System.out.println("\t" + state);
			}

			System.out.println("Select id state for update state numer");
//			numer.setState(Functions.getInteger());
			connect.getConnect();
			connect.sendObject(new Integer(UPDATE));
			connect.sendObject(numer);

		} else {
			System.out.println("Entering value failed");
			System.out.println("-------------------------");
			connect.closeSocket();
		}
	}
}
