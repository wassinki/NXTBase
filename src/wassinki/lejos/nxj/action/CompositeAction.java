package wassinki.lejos.nxj.action;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for composite action
 * A composite action consists of multiple actions
 * @author wassinki
 *
 */
public abstract class CompositeAction implements Action {
	protected final List<Action> actions;
	
	/**
	 * Constructor
	 */
	public CompositeAction(){
		actions = new ArrayList<Action>();		
	}

	
	/**
	 * Method to add actions
	 * @param action the actions to add
	 * 
	 */
	public void addAction(Action action){
		actions.add(action);
	}
	
	/**
	 * Method to remove an action
	 * @param action the action to be removed
	 *
	 */
	public void removeAction(Action action){
		actions.remove(action);
	}
	
	/**
	 * Method to get all actions
	 * @return the actions
	 */
	public List<Action> allActions(){
		return new ArrayList<Action>(actions);
	}
}
