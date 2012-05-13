package wassinki.lejos.nxj.behaviours;

import java.util.Iterator;

import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import wassinki.lejos.nxj.events.EventManagerBase;
import wassinki.lejos.nxj.events.TouchSensorStateChangedEvent;
import wassinki.lejos.nxj.events.TouchSensorStateChangedEventHandler;

/**
 * Behavior for observing the touch sensor state changes
 * @author wassinki
 *
 */
public class TouchSensorBehaviour extends EventManagerBase<TouchSensorStateChangedEventHandler> implements Behavior {
	
	/**
	 * The sensor to listen to
	 */
	private final TouchSensor sensor;
	
	/**
	 * Boolean to represent the previous state of the sensor
	 */
	private boolean isPressed;
	
	/**
	 * Constructor
	 * @param sensor the sensor to listen to
	 */
	public TouchSensorBehaviour(TouchSensor sensor) {
		isPressed = false;
		this.sensor = sensor;
	}

	@Override
	public boolean takeControl() {
		return sensor.isPressed() != isPressed;
	}

	@Override
	public  void action() {
		isPressed = sensor.isPressed();
		TouchSensorStateChangedEvent event = new TouchSensorStateChangedEvent(sensor, isPressed); 
		
		if(event.isPressed()){
			for(Iterator<TouchSensorStateChangedEventHandler> iterator = getEventHandlers().iterator(); iterator.hasNext();){
				iterator.next().touchSensorPressed(event);
			}
		} else{
			for(Iterator<TouchSensorStateChangedEventHandler> iterator = getEventHandlers().iterator(); iterator.hasNext();){
				iterator.next().touchSensorReleased(event);
			}
		}
	}

	@Override
	public void suppress() {
		
	}

}
