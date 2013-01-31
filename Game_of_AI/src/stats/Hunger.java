package stats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Hunger implements Runnable {
	
	private int			hunger			= 100;
	
	ActionListener		taskPerformer	= new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent evt) {
												if (hunger > 0) {
													hunger -= 1;
												}
											}
										};
	
	private final Timer	Controller		= new Timer(125, taskPerformer);
	
	public Hunger() {
		run();
	}
	
	/**
	 * @return the hunger
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * 
	 */
	public void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Hunger");
		Controller.stop();
	}
	
	@Override
	public void run() {
		main.World.log("Hunger Running");
		Controller.start();
	}
	
	/**
	 * @param hunger
	 *            the hunger to set
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
}
