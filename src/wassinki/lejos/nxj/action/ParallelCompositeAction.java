package wassinki.lejos.nxj.action;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing actions that are executed in parallel
 * @author wassinki
 *
 */
public class ParallelCompositeAction extends CompositeAction{

	/**
	 * Constructor
	 */
	public ParallelCompositeAction(){
		super();
	}
	
	/**
	 * Constructor
	 * @param actions the list of actions to be performed
	 */
	public ParallelCompositeAction(List<Action> actions){
		this();
		actions.addAll(actions);
	}

	@Override
	public void execute() {
		List<Thread> actionThreads = new ArrayList<Thread>();
		for(Action action : actions){
			actionThreads.add(new ActionThread(action));
		}
		
		for(Thread thread : actionThreads){
			thread.start();
		}		
	}
	
	/**
	 * Thread representing an action
	 * @author wassinki
	 *
	 */
	private class ActionThread extends Thread{
		private final Action action;
		
		/**
		 * Constructor
		 * @param action
		 */
		ActionThread(Action action){
			this.action = action;
		}
		
		public void run(){
			action.execute();
			
		}
	}
}
