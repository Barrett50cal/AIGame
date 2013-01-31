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
	
	private int				health			= 100;
	
	ActionListener			taskPerformer	= new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent evt) {
													if (getHealth() == 0) {
//														character.MC.Die();
														new Thread(new main.Kill()).start();
													}
													
												}
											};
	private static Timer	Controller;
	
	public Health() {
		run();
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}
	
	@Override
	public void run() {
		main.World.log("Health Running");
		Controller = new Timer(100, taskPerformer);
		Controller.start();
	}
	
	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}
}
