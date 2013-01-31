package character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import variables.Variables;

public class MC implements Runnable {
	private static int	localY;
	private static int	localX;
	
	public static void Die() {
		// TODO Auto-generated method stub
		System.out.println("I died.");
		Variables.setAlive(false);
		
	}
	
	public static void eat() {
		Variables.setHunger(variables.Variables.getHunger() + (100 - variables.Variables.getHunger()));
		
	}
	
	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing MC");
		Controller.stop();
	}
	
	public static void moveToFood() {
		
		if (Variables.getX() < variables.Variables.getTreeX()) {
			Variables.setRPress(true);
		} else {
			Variables.setRPress(false);
		}
		if (Variables.getX() > variables.Variables.getTreeX()) {
			Variables.setLPress(true);
		} else {
			Variables.setLPress(false);
		}
		if (Variables.getY() > variables.Variables.getTreeY()) {
			Variables.setUPress(true);
		} else {
			Variables.setUPress(false);
		}
		if (Variables.getY() < variables.Variables.getTreeY()) {
			Variables.setDPress(true);
		} else {
			Variables.setDPress(false);
		}
		if (Math.sqrt(Math.pow(Variables.getX() - variables.Variables.getTreeX(), 2) + Math.pow(Variables.getY() - variables.Variables.getTreeY(), 2)) <= Variables
				.getSize()) {
			eat();
			stopMoving();
		}
	}
	
	private static void stopMoving() {
		Variables.setDPress(false);
		Variables.setUPress(false);
		Variables.setLPress(false);
		Variables.setRPress(false);
		
	}
	
	ActionListener			taskPerformer	= new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent evt) {
													if (Variables.getHealth() < 50) {
														
													}
													if (Variables.getHunger() < 50) {
														
														moveToFood();
													}
													
												}
											};
	private static Timer	Controller;
	
	@Override
	public void run() {
		main.World.log("MC Running");
		Controller = new Timer(200, taskPerformer);
		Controller.start();
		new Thread(new stats.Hunger()).start();
		new Thread(new stats.Health()).start();
		new Thread(new stats.Social()).start();
		
	}
}
