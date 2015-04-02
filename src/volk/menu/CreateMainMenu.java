package volk.menu;

import java.util.ArrayList;

import volk.client.Connector;
import volk.util.Functions;

public class CreateMainMenu {

	public CreateMainMenu() {
		Connector connect = new Connector();
		AMenu root = new MainMenu(null, null);
		AMenu menuNumer = new MenuNumer(root, connect);
		AMenu menuGuest = new MenuGuest(root, connect);
		AMenu menuService = new MenuService(root, connect);
		new ExitProgramm(root, connect);
		new ViewNumers(menuNumer, connect);
		new ViewGuests(menuGuest, connect);
		new ViewServices(menuService, connect);
		new ViewCountNumber(menuNumer, connect);
		new ViewNotEmptyNumbers(menuNumer, connect);
		new NewNumer(menuNumer, connect);
		new UpdateStateNumer(menuNumer, connect);
		new CloningNumber(menuNumer, connect);
		new NewGuest(menuGuest, connect);
		new NewService(menuService, connect);
		new DeleteService(menuService, connect);
		new ServicesInGuest(menuGuest, connect);
		new ViewServicesInGuest(menuGuest, connect);
		new DeleteServiceFromGuest(menuGuest, connect);
		new DeleteGuest(menuGuest, connect);
		new DeleteNumer(menuNumer, connect);
		new ServiceAddGuest(menuGuest, connect);
		AMenu menu = root;
		while (true) {
			boolean check = true;
			while (check) {
				try {

					System.out.println(menu.name);
					System.out.println("-----------------------------");
					int numMenu = 1;
					if (menu.getSize() == 0) {
						menu.callMenu();
						System.out.println("------------------------------");
						menu = menu.getParent();
					}

					for (AMenu menuItem : (ArrayList<AMenu>) menu.getListMenu()) {

						System.out.println(numMenu++ + ". " + menuItem.name);
					}

					if ((menu.getParent() != null) && (menu.getSize() != 0))
						System.out.println(numMenu + ". " + "<-EXIT "
								+ menu.name.toUpperCase());

					int select = Functions.getInteger();

					if (select == (menu.getListMenu().size() + 1)) {
						menu = menu.getParent();

					} else {
						menu = menu.getItemMenu(select - 1);
					}
					check = false;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Repeat enter");
				}
			}

		}
	}
}
