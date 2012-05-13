package wassinki.lejos.nxj;

import wassinki.lejos.nxj.ui.menu.Menu;

/**
 * Skeleton for application
 * @author wassinki
 *
 */
public abstract class AbstractApp {
	
	/**
	 * Boolean to remember the app has been started
	 */
	private boolean isStarted = false;
	
	/**
	 * Method to create the menu
	 * @return the menu
	 */
	public abstract Menu createMenu();
	
	public void start(){
		if(!isStarted){
			isStarted = true;
			createMenu().show();
		}
	}
}
