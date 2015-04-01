package volk.query;

import java.util.List;

import volk.client.Connector;
import volk.domain.Numer;
import volk.domain.StateNumer;
import volk.util.Functions;

public class QueryStateNumer extends AQuery {

	public QueryStateNumer(Connector connect) {
		super(connect);

	}

	public StateNumer getStateNumer() {
		StateNumer state = new StateNumer();
		for (StateNumer stateList : getListStateNumers()) {
			System.out.println(stateList);
		}
		System.out.println("Select id state numer");
		state.setId(Functions.getInteger());
		connect.getConnect();
		connect.sendObject(SELECTPK);
		connect.sendObject(state);
		state = (StateNumer) connect.receiveObject();
		return state;
		
	}

	public List<StateNumer> getListStateNumers() {
		connect.getConnect();
		connect.sendObject(SELECT);
		connect.sendObject(new StateNumer());
		return (List<StateNumer>) connect.receiveObject();
	}
}
