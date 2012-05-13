package wassinki.lejos.nxj.behaviours;

import java.util.ArrayList;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * Behavior manager is a skin over the standard behaviors to simplify the control
 * @author wassinki
 *
 */
public class BehaviorManager {
	/**
	 * List of behaviors
	 */
	private final ArrayList<Behavior> behaviors;
	
	/**
	 * The arbitrator
	 */
	private Arbitrator arbitrator;
	
	/**
	 * Variable to determine if the arbitrator hasn't been started
	 */
	private boolean arbitratorIsStarted;
	
	/**
	 * Constructor
	 */
	public BehaviorManager(){
		behaviors = new ArrayList<Behavior>();
		arbitratorIsStarted = false;
	}
	
	/**
	 * Method to add a behavior
	 * @throws ArbitratorAlreadyStartedException 
	 */
	public void addBehavior(Behavior behavior) throws ArbitratorAlreadyStartedException{
		if(arbitrator == null){
			behaviors.add(behavior);
		} else{
			throw new ArbitratorAlreadyStartedException();
		}
	}
			

	/**
	 * Method to start the arbitrator
	 * @throws ArbitratorAlreadyStartedException
	 */
	public void start() throws ArbitratorAlreadyStartedException{
		if (!arbitratorIsStarted) {
			arbitratorIsStarted = true;
			createArbitrator();
			new Thread() {
				public void run() {
					arbitrator.start();
				}
			}.start();
		}
	}
	
	
	/**
	 * Method to create the arbitrator
	 */
	private void createArbitrator(){
		Behavior[] bhvrs = new Behavior[behaviors.size()];
		arbitrator = new Arbitrator(behaviors.toArray(bhvrs));
	}
}
