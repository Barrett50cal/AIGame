package character;

import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import variables.Variables;

public class MC implements Runnable {
	private static int localY;
	private static int localX;

	public static void complain() {
		if (Variables.getHealth() < 50) {
			System.out.println("I'm injured.");
		} else if (Variables.getHunger() < 50) {
			System.out.println("I'm Hungry");
			moveToFood();
		} else {
			System.out.println("I'm Happy");
			//
		}

	}

	private static void moveToFood() {
		if (Math.sqrt(Math.pow(
				Variables.getX() - variables.Variables.getTreex(), 2)
				+ Math.pow(
						Variables.getY() - variables.Variables.getTreey(),
						2)) <= size) {
			Variables.setHunger(variables.Variables.getHunger()
					+ (100 - variables.Variables.getHunger()));
		}
		localY = variables.Variables.getTreex();
		localY = variables.Variables.getTreey();
		Variables.setX(localX - Variables.speed);
		Variables.setY(localY - Variables.speed);
		if (Variables.getX() < variables.Variables.getTreex())
			localX += Variables.speed;
		else
			localX -= Variables.speed;
		if (Variables.getY() < variables.Variables.getTreey())
			localY += Variables.speed;
		else
			localY -= Variables.speed;
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

	}
}
