package wassinki.lejos.nxj.action;

import wassinki.lejos.nxj.action.Action;
/**
 * Menu action to exit
 * @author wassinki
 *
 */
public class ExitAction implements Action{

	@Override
	public void execute() {
		System.exit(0);
		
	}

}
