package volk.query;

import java.util.List;

import volk.client.Connector;
import volk.dao.DaoServiceInGuest;
import volk.domain.Guest;
import volk.domain.Service;
import volk.domain.ServiceInGuest;

public class QueryServiceInGuest extends AQuery{

	public QueryServiceInGuest(Connector connect) {
		super(connect);
		
	}
	public List<ServiceInGuest> getListServiceInGuests(Guest guest) {
		connect.getConnect();
		connect.sendObject(SELECTPK);
		ServiceInGuest s=new ServiceInGuest();
		s.setIdGuest(guest);
		connect.sendObject(s);
		return (List<ServiceInGuest>) connect.receiveObject();
	}
	public List<ServiceInGuest> getListServiceInGuests() {
		connect.getConnect();
		connect.sendObject(SELECT);
		connect.sendObject(new ServiceInGuest());
		return (List<ServiceInGuest>) connect.receiveObject();
	}
	public void insertServiceInGuests(ServiceInGuest serviceInGuest) {
		connect.getConnect();
		connect.sendObject(INSERT);
		connect.sendObject(serviceInGuest);
	}

}
