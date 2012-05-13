package wassinki.lejos.nxj;

import wassinki.lejos.nxj.behaviours.ArbitratorAlreadyStartedException;
import wassinki.lejos.nxj.behaviours.BehaviorManager;

/**
 * Base class for creating robots
 * @author wassinki
 *
 */
public abstract class AbstractRobot<BloackboardClass extends Blackboard> {
	/**
	 * The behavior manager
	 */
	private final BehaviorManager behaviorManager;
	
	/**
	 * The black board 
	 */
	protected final BloackboardClass blackboard;
	
	/**
	 * Constructor
	 * @param blackboard the black board to be used
	 */
	public AbstractRobot(BloackboardClass blackboard) {
		behaviorManager = new BehaviorManager();
		this.blackboard = blackboard;
	}
	
	
	/**
	 * @return the blackboard
	 */
	public BloackboardClass getBlackboard() {
		return blackboard;
	}
	
	/**
	 * Method to get the behavior manager
	 * @return the behavior manager
	 */
	protected BehaviorManager getBehaviourManager(){
		return behaviorManager;
	}
	
	
	/**
	 * Starts the robot
	 */
	public void start() {
		if (!blackboard.isStarted()) {
			blackboard.setStarted(true);
			try {
				getBehaviourManager().start();
			} catch (ArbitratorAlreadyStartedException e) {
				System.out.println("eror starting");
			}
		}
	}
}
