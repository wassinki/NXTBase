package wassinki.lejos.nxj.action;

import java.util.List;


/**
 * A sequential action consists of multiple actions that are executed in sequential order
 * @author wassinki
 *
 */
public class SequentialCompositeAction extends CompositeAction {

	/**
	 * Constructor
	 */
	public SequentialCompositeAction(){
		super();
	}
	
	/**
	 * Constructor
	 * @param actions the list of actions to be performed
	 */
	public SequentialCompositeAction(List<Action> actions){
		this();
		actions.addAll(actions);
	}
	
	/**
	 * Method to get all actions
	 * @return the action
	 */
	@Override
	public void execute() {
		for(Action action : actions){
			action.execute();
		}		
	}

}
