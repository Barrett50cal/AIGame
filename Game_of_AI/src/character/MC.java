package character;

import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import variables.Variables;

public class MC implements Runnable {
	private static int localY;
	private static int localX;

	public static void complain() {
		if (Variables.getHealth() <  5650) {
			// System.out.println("I'm injured.");
		} else if (Variables.getHunger() < 50) {
			// System.out.println("I'm Hungry");
			moveToFood();
		} else {
			// System.out.println("I'm Happy");
			//
		}

	}

	private static void moveToFood() {
		if (Math.sqrt(Math.pow(
				Variables.getX() - variables.Variables.getTreex(), 2)
				+ Math.pow(Variables.getY() - variables.Variables.getTreey(), 2)) <= Variables
				.getSize()) {
			Variables.setHunger(variables.Variables.getHunger()
					+ (100 - variables.Variables.getHunger()));
		}
		localX = variables.Variables.getTreex();
		localY = variables.Variables.getTreey();
		
			if (variables.Variables.getTreex() > Variables.getX())
				Variables.setX(Variables.getX() + Variables.speed);
			if (variables.Variables.getTreex() < Variables.getX())
				Variables.setX(Variables.getX() - Variables.speed);

		if (Variables.getY() < variables.Variables.getTreey())
			if (variables.Variables.getTreey() - Variables.getY() > 0)
				Variables.setY(Variables.getY() + Variables.speed);
			else if (variables.Variables.getTreey() - Variables.getY() < 0)
				Variables.setY(Variables.getY() - Variables.speed);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Die() {
		// TODO Auto-generated method stub
		System.out.println("I died.");

	}

	public static void eat() {
		Variables.setHunger(Variables.getHunger() + 50);
	}

	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing MC");
	}

	@Override
	public void run() {
		main.World.log("MC Running");

		new Thread(new stats.Hunger()).start();
		new Thread(new stats.Health()).start();
		new Thread(new stats.Social()).start();

	}
}
