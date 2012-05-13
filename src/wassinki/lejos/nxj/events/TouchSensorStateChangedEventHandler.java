package wassinki.lejos.nxj.events;

/**
 * Listener interface for touch state events
 * @author wassinki
 *
 */
public interface TouchSensorStateChangedEventHandler extends EventHandler{
	/**
	 * Method called when the touch sensor is pressed
	 * @param event the event
	 */
	public void touchSensorPressed(TouchSensorStateChangedEvent event);
	
	/**
	 * Method called when the touch sensor is released
	 * @param event the event
	 */
	public void touchSensorReleased(TouchSensorStateChangedEvent event);
}
