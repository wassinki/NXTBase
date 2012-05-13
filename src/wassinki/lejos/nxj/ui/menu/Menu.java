package wassinki.lejos.nxj.ui.menu;

import java.util.ArrayList;
import java.util.List;

import lejos.nxt.LCD;
import lejos.util.TextMenu;
import wassinki.lejos.nxj.action.Action;

/**
 * Menu item
 * 
 * @author wassinki
 * 
 */
public class Menu extends MenuItem {
	private final List<MenuItem> menuItems;
	private final MenuItem backItem;

	// Menu object
	private final TextMenu textMenu;

	/**
	 * Constructor
	 * 
	 * @param title
	 *            the title
	 */
	public Menu(String title) {
		this(title, null);
	}

	/**
	 * Constructor
	 * 
	 * @param title
	 *            the title
	 * @param parent
	 *            the parent menu
	 */
	public Menu(String title, Menu parent) {
		this(title, new ArrayList<MenuItem>(), parent);
	}

	/**
	 * Constructor
	 * 
	 * @param title
	 *            the title
	 * @param parent
	 *            the parent menu
	 */
	public Menu(String title, List<MenuItem> menuItems, Menu parent) {
		super(title, new MenuItemHitAction());
		((MenuItemHitAction)this.action).setMenu(this);
		
		this.menuItems = new ArrayList<MenuItem>(menuItems);

		// Add back button if parent is given
		backItem = (parent != null) ? new BackMenuItem(parent) : null;

		textMenu = new TextMenu(new String[] {});
		textMenu.setTitle(title);
		setMenuItems();
	}

	/**
	 * Alias for hit
	 */
	public void show(){
		hit();
	}
	

	/**
	 * Method to add a menu item
	 * 
	 * @param menuItem
	 *            the menu item to add
	 * 
	 */
	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
		setMenuItems();
	}

	/**
	 * Method to delete a menu item
	 * 
	 * @param menuItem
	 *            the menu item to delete
	 * 
	 */
	public void removeMenuItem(MenuItem menuItem) {
		if (menuItems.remove(menuItem)) {
			setMenuItems();
		}
	}

	/**
	 * Method for setting the menu items
	 */
	private void setMenuItems() {
		// Generate text menu
		int arraySize = (backItem != null) ? menuItems.size() + 1
				: menuItems.size();
		String[] itemTexts = new String[arraySize];
		int index = 0;
		for (MenuItem item : menuItems) {
			itemTexts[index++] = item.getText();
		}

		// Add back item if parent is given
		if (backItem != null) {
			itemTexts[index] = backItem.getText();
		}
		textMenu.setItems(itemTexts);
	}
	
	/**
	 * Method for performing the menu action
	 */
	private static class MenuItemHitAction implements Action{
		private Menu menu;
		private int selectedIndex;
		
		/**
		 * Method to set the menu
		 * @param menu the menu
		 */
		public void setMenu(Menu menu){
			this.menu = menu;
			selectedIndex = 0;
		}
		
		/**
		 * Method to perform the action
		 */
		public void execute(){
			LCD.clear();
			selectedIndex = menu.textMenu.select(selectedIndex);
			if (selectedIndex >= 0 && selectedIndex < menu.menuItems.size()) {
				MenuItem selectedItem = menu.menuItems.get(selectedIndex);
				selectedItem.hit();				
				menu.show();				
			} else if(menu.backItem != null){
				menu.backItem.hit();
			} else{
				System.exit(0);
			}
		}
	}

	/**
	 * Back button
	 * 
	 * @author wassinki
	 * 
	 */
	private class BackMenuItem extends MenuItem {		
		/**
		 * Constructor
		 * 
		 * @param text
		 */
		public BackMenuItem(Menu parentMenu) {
			super("Back", new BackAction(parentMenu));
		}
	}
	
	/**
	 * Action to perform the back option
	 */
	private class BackAction implements Action{
		private final Menu parentMenu;
		
		private BackAction(Menu parentMenu){
			this.parentMenu = parentMenu;
		}
		
		@Override
		public void execute() {
			parentMenu.hit();			
		}
		
	}
	
}
