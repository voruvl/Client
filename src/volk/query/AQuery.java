package volk.query;

import volk.client.Connector;

public abstract class AQuery {
	Connector connect;
	protected static final Integer EXIT=0;
	protected static final Integer SELECT=1;
	protected static final Integer INSERT=2;
	protected static final Integer UPDATE=3;
	protected static final Integer DELETE=4;
	protected static final Integer SELECTPK = 5;
	protected static final Integer SELECTPKLIST = 6;
	public AQuery(Connector connect) {
		
		this.connect = connect;
	}
	
}
