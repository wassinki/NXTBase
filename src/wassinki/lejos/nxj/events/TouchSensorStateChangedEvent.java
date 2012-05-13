package wassinki.lejos.nxj.events;

import lejos.nxt.TouchSensor;

/**
 * Event created when the touch sensor is pressed or released
 * @author wassinki
 *
 */
public class TouchSensorStateChangedEvent extends Event {
	/**
	 * Boolean to notice whether the touch sensor is pressed or not
	 */
	private final boolean isPressed;
	
	/**
	 * Constructor 
	 * @param target the target
	 */
	public TouchSensorStateChangedEvent(TouchSensor target, boolean isPressed){
		super(target);
		this.isPressed = isPressed;
	}

	
	/**
	 * Method get the isPressed state
	 * @return true if is pressed
	 */
	public boolean isPressed(){
		return isPressed;
	}
	
	/**
	 * Method to get the isReleased state
	 * @return true if the button is released
	 */
	public boolean isReleased(){
		return !isPressed;
	}
}
