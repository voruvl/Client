package volk.query;

import java.util.List;

import volk.client.Connector;
import volk.domain.Guest;
import volk.domain.Service;
import volk.util.Functions;

public class QueryService extends AQuery {

	public QueryService(Connector connect) {
		super(connect);

	}

	public Service getService() {
		Service service = new Service();
		for (Service serviceList : getListsServices()) {
			System.out.println(serviceList);
		}
		System.out.println("Select id service");

		service.setId(Functions.getInteger());
		connect.getConnect();
		connect.sendObject(SELECTPK);
		connect.sendObject(service);
		service = (Service) connect.receiveObject();
		return service;
	}

	public Service getService(int id) {
		Service service = new Service();
		service.setId(id);
		connect.getConnect();
		connect.sendObject(SELECTPK);
		connect.sendObject(service);
		service = (Service) connect.receiveObject();
		return service;
	}

	public List<Service> getListsServices() {
		connect.getConnect();
		connect.sendObject(SELECT);
		connect.sendObject(new Service());
		return (List<Service>) connect.receiveObject();
	}

	public void deleteService(Service service) {
		connect.getConnect();
		connect.sendObject(DELETE);
		connect.sendObject(service);
	}
	public void insertService(Service service) {
		connect.getConnect();
		connect.sendObject(INSERT);
		connect.sendObject(service);
	}
}
