package characters;

import helpers.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Timer;

import main.World;
import stats.Health;
import stats.Hunger;
import stats.Social;

public class Monster {
	private static final int		MAX_DISTANCE		= 400;
	ActionListener					ControllerCustom	= new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent evt) {
																if (health.getHealth() < 50) {
																	
																}
																if (hunger.getHunger() < 50) {
																	
																	moveToFood();
																}
															}
															
														};
	private int						x					= 0, y = 0;
	private boolean					isAlive;
	private boolean					isUPress;
	private boolean					isDPress;
	private boolean					isLPress;
	private boolean					isRPress;
	private Social					social;
	private String					name;
	private Health					health;
	private Hunger					hunger;
	public final int				RefreshSpeed		= 4;
	public final int				speed				= 1;
	private final List<Integer>		DistList			= new ArrayList<Integer>();
	Timer							CCTimer				= new Timer(100, ControllerCustom);
	private characters.Character	target;
	ActionListener					movementListener	= new ActionListener() {
															
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
	
	private final Timer				Controller2			= new Timer(RefreshSpeed, movementListener);
	
	public Monster(String x, boolean isLiving, boolean isControllerd) {
		name = x;
		isAlive = isLiving;
		run();
	}
	
	private void eat() {
		hunger.setHunger(hunger.getHunger() + (100 - hunger.getHunger()));
		
	}
	
	private characters.Character findClosestFood(Object[] objects) {
		DistList.clear();
		
		for (int i = 0; i < World.getCharArray().length; i++) {
//			System.out.println(i);
//			System.out.println(World.getCharArray(i));
			for (int x = 0; x <= MAX_DISTANCE; x++) {
				if (Utils.getDistance(World.getCharArray(i).getX(), World.getCharArray(i).getY(), x, y) < x) {
					DistList.add(x);
					break;
				}
			}
//			System.out.println(DistList.indexOf(Collections.min(DistList)));
		}
		
		return World.getCharArray(DistList.indexOf(Collections.min(DistList)));
	}
	
	/**
	 * @return the cCTimer
	 */
	public Timer getCCTimer() {
		return CCTimer;
	}
	
	/**
	 * @return the controllerCustom
	 */
	public ActionListener getControllerCustom() {
		return ControllerCustom;
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health.getHealth();
	}
	
	/**
	 * @return the hunger
	 */
	public int getHunger() {
		return hunger.getHunger();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the social
	 */
	public Social getSocial() {
		return social;
	}
	
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
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
	
	private void moveToFood() {
		if (target == null) {
			target = findClosestFood(World.getCharArray());
		}
		
		if (x < target.getX()) {
			isRPress = true;
		} else if (x > target.getX()) {
			isLPress = true;
		}
		if (y > target.getY()) {
			isUPress = true;
		} else if (y < target.getY()) {
			isDPress = true;
		}
		if (Math.sqrt(Math.pow(x - target.getX(), 2) + Math.pow(y - target.getY(), 2)) <= 25 - 2) {
			eat();
			stopMoving();
		}
	}
	
	public void run() {
		
		if (isAlive) {
			System.out.println(name + " running");
			CCTimer.start();
			Controller2.start();
//			Controller.start();
			
			hunger = new stats.Hunger();
			health = new stats.Health();
			social = new stats.Social();
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
	 * @param cCTimer
	 *            the cCTimer to set
	 */
	public void setCCTimer(Timer cCTimer) {
		CCTimer = cCTimer;
	}
	
	/**
	 * @param controllerCustom
	 *            the controllerCustom to set
	 */
	public void setControllerCustom(ActionListener controllerCustom) {
		ControllerCustom = controllerCustom;
	}
	
	/**
	 * @param isDPress
	 *            the isDPress to set
	 */
	public void setDPress(boolean isDPress) {
		this.isDPress = isDPress;
	}
	
	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(Health health) {
		this.health = health;
	}
	
	/**
	 * @param hunger
	 *            the hunger to set
	 */
	public void setHunger(Hunger hunger) {
		this.hunger = hunger;
	}
	
	/**
	 * @param isLPress
	 *            the isLPress to set
	 */
	public void setLPress(boolean isLPress) {
		this.isLPress = isLPress;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param isRPress
	 *            the isRPress to set
	 */
	public void setRPress(boolean isRPress) {
		this.isRPress = isRPress;
	}
	
	/**
	 * @param social
	 *            the social to set
	 */
	public void setSocial(Social social) {
		this.social = social;
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
	
	private void stopMoving() {
		isDPress = false;
		isUPress = false;
		isLPress = false;
		isRPress = false;
		
	}
}
