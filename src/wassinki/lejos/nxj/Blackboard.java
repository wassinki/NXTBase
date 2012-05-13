package wassinki.lejos.nxj;

/**
 * Abstract black board class
 * @author wassinki
 *
 */
public abstract class Blackboard {

	/**
	 * Boolean if robot is started
	 */
	private boolean isStarted;


	/**
	 * Constructor
	 */
	public Blackboard(){
		isStarted = false;
	}
	
	/**
	 * @return the isStarted
	 */
	public boolean isStarted() {
		return isStarted;
	}

	/**
	 * @param isStarted the isStarted to set
	 */
	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
}
