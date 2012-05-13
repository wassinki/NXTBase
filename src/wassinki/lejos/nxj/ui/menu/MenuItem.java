package wassinki.lejos.nxj.ui.menu;

import wassinki.lejos.nxj.action.Action;


/**
 * Menu item class
 * 
 * @author wassinki
 * 
 */
public class MenuItem {
	protected final String text;
	protected final Action action;
	
	/**
	 * Constructor
	 * @param text the xt
	 */
	public MenuItem(String text, Action action) {
		this.text = text;
		this.action = action;
	}

	/**
	 * Method for getting the text
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}
			
	/**
	 * Interface method for performing the action
	 */
	public void hit(){
		action.execute();
	}
}
