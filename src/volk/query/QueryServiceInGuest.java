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
		connect.sendObject(SELECTPK);
		ServiceInGuest s=new ServiceInGuest();
		s.setIdGuest(guest);
		connect.sendObject(s);
		return (List<ServiceInGuest>) connect.receiveObject();
	}
	public ServiceInGuest getListServiceInGuests(ServiceInGuest servGuest) {
		connect.getConnect();
		connect.sendObject(SELECTPK);
		ServiceInGuest s=new ServiceInGuest();
		s.setIdGuest(servGuest.getIdGuest());
		s.setIdService(servGuest.getIdService());
		connect.sendObject(s);
		return (ServiceInGuest)connect.receiveObject();
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
	public void deleteServiceInGuests(ServiceInGuest serviceInGuest) {
		connect.getConnect();
		connect.sendObject(DELETE);
		connect.sendObject(serviceInGuest);
	}

}
