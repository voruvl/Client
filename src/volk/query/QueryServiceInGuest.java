package volk.query;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.ServiceInGuest;

public class QueryServiceInGuest extends AQuery{

	public QueryServiceInGuest(Connector connect) {
		super(connect);
		
	}
	public List<ServiceInGuest> getListServiceInGuests(Guest guest) {
		connect.getConnect();
		connect.sendObject(SELECTPKLIST);
		ServiceInGuest s=new ServiceInGuest();
		s.setIdGuest(guest);
		connect.sendObject(s);
		return (List<ServiceInGuest>) connect.receiveObject();
	}	

}
