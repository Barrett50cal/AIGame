package stats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Health implements Runnable {
	
	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Health");
		Controller.stop();
		
	}
	
	ActionListener			taskPerformer	= new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent evt) {
													if (variables.Variables.getHealth() == 0) {
														character.MC.Die();
													} else {
														variables.Variables.setHunger(variables.Variables.getHunger() - 2);
													}
													
												}
											};
	private static Timer	Controller;
	
	@Override
	public void run() {
		main.World.log("Health Running");
		Controller = new Timer(100, taskPerformer);
		Controller.start();
	}
	
}
