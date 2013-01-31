package character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import stats.Health;
import stats.Hunger;
import stats.Social;
import enviro.Tree;

public class Character implements Runnable {
	private int				x					= 0, y = 0;
	
	private boolean			isAlive;
	private boolean			isUPress;
	private boolean			isDPress;
	private boolean			isLPress;
	private boolean			isRPress;
	private Social			social;
	
	private Health			health;
	
	private Hunger			hunger;
	
	public final int		speed				= 1;
	
	ActionListener			taskPerformer		= new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent evt) {
														if (health.getHealth() < 50) {
															
														}
														if (hunger.getHunger() < 50) {
															
															moveToFood();
														}
														if (social.getSocial() < 50) {
															findABuddy();
														}
														
													}
												};
	ActionListener			movementListener	= new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent evt) {
														if (isRPress == true) {
															x = (x + speed);
															
														}
														if (isLPress == true) {
															x = (x - speed);
															
														}
														if (isDPress == true) {
															y = (y + speed);
															
														}
														if (isUPress == true) {
															y = (y - speed);
															
														}
													}
												};
	
	private final String	name;
	private final Timer		Controller			= new Timer(50, taskPerformer), Controller2 = new Timer(5, movementListener);
	
	public Character(String x, boolean isLiving) {
		isAlive = isLiving;
		name = x;
		run();
	}
	
	public Character(String x, boolean isLiving, boolean isControlled) {
		isAlive = isLiving;
		if (isControlled == true) {
			System.out.println("Controller Running");
			Controller2.start();
		}
		name = x;
		run();
	}
	
	public void eat() {
		hunger.setHunger(hunger.getHunger() + (100 - hunger.getHunger()));
		
	}
	
	protected void findABuddy() {
		if (x < main.World.getMainChar().getX()) {
			isRPress = true;
		} else if (x > main.World.getMainChar().getX()) {
			isLPress = true;
		}
		if (y > main.World.getMainChar().getY()) {
			isUPress = true;
		} else if (y < main.World.getMainChar().getY()) {
			isDPress = true;
		}
		if (Math.sqrt(Math.pow(x - main.World.getMainChar().getX(), 2) + Math.pow(y - main.World.getMainChar().getY(), 2)) <= 30) {
			socialize();
			stopMoving();
		}
		
	}
	
	public int getHealth() {
		return health.getHealth();
		
	}
	
	public int getHunger() {
		// TODO Auto-generated method stub
		return hunger.getHunger();
	}
	
	public int getSocial() {
		// TODO Auto-generated method stub
		return social.getSocial();
	}
	
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * @return the isDPress
	 */
	public boolean isDPress() {
		return isDPress;
	}
	
	/**
	 * @return the isLPress
	 */
	public boolean isLPress() {
		return isLPress;
	}
	
	/**
	 * @return the isRPress
	 */
	public boolean isRPress() {
		return isRPress;
	}
	
	/**
	 * @return the isUPress
	 */
	public boolean isUPress() {
		return isUPress;
	}
	
	public void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing MC");
		Controller.stop();
		Controller2.stop();
	}
	
	public void moveToFood() {
		
		if (x < Tree.getTreex()) {
			isRPress = true;
		} else if (x > Tree.getTreex()) {
			isLPress = true;
		}
		if (y > Tree.getTreey()) {
			isUPress = true;
		} else if (y < Tree.getTreey()) {
			isDPress = true;
		}
		if (Math.sqrt(Math.pow(x - Tree.getTreex(), 2) + Math.pow(y - Tree.getTreey(), 2)) <= Tree.getSize() - 2) {
			eat();
			stopMoving();
		}
	}
	
	@Override
	public void run() {
		
		if (isAlive) {
			System.out.println(name + " running");
			
			Controller.start();
			hunger = new stats.Hunger();
			health = new stats.Health();
			social = new stats.Social();
		} else {
			kill();
		}
		
	}
	
	/**
	 * @param isAlive
	 *            the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * @param isDPress
	 *            the isDPress to set
	 */
	public void setDPress(boolean isDPress) {
		this.isDPress = isDPress;
	}
	
	public void setHealth(int i) {
		health.setHealth(health.getHealth() + i);
		
	}
	
	public void setHunger(int i) {
		hunger.setHunger(hunger.getHunger() + i);
		
	}
	
	/**
	 * @param isLPress
	 *            the isLPress to set
	 */
	public void setLPress(boolean isLPress) {
		this.isLPress = isLPress;
	}
	
	/**
	 * @param isRPress
	 *            the isRPress to set
	 */
	public void setRPress(boolean isRPress) {
		this.isRPress = isRPress;
	}
	
	/**
	 * @param isUPress
	 *            the isUPress to set
	 */
	public void setUPress(boolean isUPress) {
		this.isUPress = isUPress;
	}
	
	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	private void socialize() {
		// TODO Auto-generated method stub
		
	}
	
	private void stopMoving() {
		isDPress = false;
		isUPress = false;
		isLPress = false;
		isRPress = false;
		
	}
}