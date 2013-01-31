package stats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Hunger implements Runnable, ActionListener {
	private static Timer	Controller;
	
	/**
	 * 
	 */
	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Hunger");
		Controller.stop();
	}
	
	ActionListener	taskPerformer	= new ActionListener() {
										@Override
										public void actionPerformed(ActionEvent evt) {
											if (variables.Variables.getHunger() < 1) {
												variables.Variables.setHealth(variables.Variables.getHealth() - 1);
												
											} else {
												variables.Variables.setHunger(variables.Variables.getHunger() - 2);
											}
											
										}
									};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void run() {
		main.World.log("Hunger Running");
		Controller = new Timer(100, taskPerformer);
		Controller.start();
	}
	
}
