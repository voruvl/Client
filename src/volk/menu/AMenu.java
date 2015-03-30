package volk.menu;

import java.util.ArrayList;
import java.util.List;

import volk.client.Connector;

public abstract class AMenu {
	protected AMenu menuParent;
	protected List<AMenu> listMenu = new ArrayList<AMenu>();
	protected String name;
	protected Connector connect;
	protected static final Integer EXIT=0;
	protected static final Integer SELECT=1;
	protected static final Integer INSERT=2;
	protected static final Integer UPDATE=3;
	protected static final Integer DELETE=4;
	protected static final Integer SELECTPK = 5;
	protected static final Integer SELECTPKLIST = 6;
	public AMenu(AMenu parentMenu,Connector connect) {
		this.connect=connect;
		menuParent = parentMenu;
		

		if (parentMenu != null)
			parentMenu.listMenu.add(this);
	}

	public abstract void callMenu();

	public AMenu getItemMenu(int item) {
		return listMenu.get(item);
	}

	public List<AMenu> getListMenu() {
		return listMenu;
	}

	public AMenu getParent() {
		return menuParent;
	}

	public int getSize() {
		return listMenu.size();
	}

	public String getName() {
		return name;

	}
}
