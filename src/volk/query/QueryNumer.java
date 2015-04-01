package volk.query;

import java.util.List;

import volk.client.Connector;
import volk.domain.Numer;
import volk.util.Functions;

public class QueryNumer extends AQuery {

	public QueryNumer(Connector connect) {
		super(connect);

	}

	public Numer getNumer() {
		Numer numer=new Numer() ;	
		for (Numer numerlist : getListNumers()) {
			System.out.println(numerlist);
		}
		System.out.println("Select id numer");
		
		numer.setId(Functions.getInteger());
		connect.getConnect();
		connect.sendObject(SELECTPK);
		connect.sendObject(numer);
		numer = (Numer) connect.receiveObject();
		return numer;
	}

	public List<Numer> getListNumers() {
		connect.getConnect();
		connect.sendObject(SELECT);
		connect.sendObject(new Numer());
		return (List<Numer>) connect.receiveObject();
	}
}
