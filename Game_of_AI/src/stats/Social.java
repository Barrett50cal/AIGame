package stats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Social implements Runnable {
	
	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Social");
		Controller.stop();
	}
	
	ActionListener			taskPerformer	= new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent evt) {
													if (variables.Variables.getSocial() < 1) {
														variables.Variables.setHealth(variables.Variables.getHealth() - 1);
													} else {
														variables.Variables.setSocial(variables.Variables.getSocial() - 2);
													}
													
												}
											};
	private static Timer	Controller;
	
	@Override
	public void run() {
		main.World.log("Social Running");
		Controller = new Timer(100, taskPerformer);
		Controller.start();
	}
}
