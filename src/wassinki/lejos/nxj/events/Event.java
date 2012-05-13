package wassinki.lejos.nxj.events;

/**
 * Abstract class for event handling
 */
public abstract class Event {
	/**
	 * The target
	 */
	private final Object target;
	
	/**
	 * Constructor
	 * @param target
	 */
	public Event(Object target){
		this.target = target;
	}
	
	/**
	 * Method to get the target
	 * @return the target
	 */
	public Object getTarget() {
		return target;
	}

}
