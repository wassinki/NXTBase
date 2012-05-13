package wassinki.lejos.nxj.events;

import java.util.ArrayList;

/**
 * Base class for event managers
 * @author wassinki
 *
 */
public abstract class EventManagerBase<EventHandlerClass extends EventHandler> {
	
	/**
	 * The list of event handlers
	 */
	private final ArrayList<EventHandlerClass> eventHandlers;

	/**
	 * Constuctor
	 */
	public EventManagerBase() {
		eventHandlers = new ArrayList<EventHandlerClass>();
	}
	
	/**
	 * Method to add an event handler
	 * @param eventHandler the event handler
	 */
	public synchronized void addEventHandler(EventHandlerClass eventHandler){
		eventHandlers.add(eventHandler);
	}
	
	/**
	 * Method to remove an event handler
	 * @param eventHandler the event handler
	 */
	public synchronized void removeEventHandler(EventHandlerClass eventHandler){
		eventHandlers.remove(eventHandler);
	}

	protected synchronized ArrayList<EventHandlerClass> getEventHandlers(){
		return new ArrayList<EventHandlerClass>(eventHandlers);
	}
}
