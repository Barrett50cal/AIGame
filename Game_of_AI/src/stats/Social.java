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
	
	private int				social			= 100;
	
	ActionListener			taskPerformer	= new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent evt) {
													if (social > 0) {
														social -= 2;
													}
													
												}
											};
	
	private static Timer	Controller;
	
	public Social() {
		run();
	}
	
	/**
	 * @return the social
	 */
	public int getSocial() {
		return social;
	}
	
	@Override
	public void run() {
		main.World.log("Social Running");
		Controller = new Timer(100, taskPerformer);
		Controller.start();
	}
	
	/**
	 * @param social
	 *            the social to set
	 */
	public void setSocial(int social) {
		this.social = social;
	}
}
