package wassinki.lejos.nxj.behaviours;

import lejos.robotics.subsumption.Behavior;
import wassinki.lejos.nxj.AbstractRobot;
import wassinki.lejos.nxj.Blackboard;

/**
 * Behavior class related to a robot
 * This abstract behavior contains methods to get the robot
 * @author wassinki
 *
 * @param <RobotClass>
 */
public abstract class AbstractBehavior <RobotClass extends AbstractRobot<? extends Blackboard>> implements Behavior{

	/**
	 * The robot
	 */
	private final RobotClass robot;
	
	/**
	 * Constructor
	 * @param robot
	 */
	public AbstractBehavior(RobotClass robot){
		this.robot = robot;
	}
	
	/**
	 * Method to get the robot
	 * @return the robot
	 */
	public RobotClass getRobot(){
		return robot;
	}
}
