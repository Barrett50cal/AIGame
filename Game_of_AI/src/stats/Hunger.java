package stats;

public class Hunger implements Runnable {

	private static int timer = 0;

	/**
	 * 
	 */
	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Hunger");
	}

	public void run() {
		main.World.log("Hunger Running");
		while (variables.Variables.isRunning == true) {
			if (variables.Variables.hunger == 0) {
				character.MC.Die();
			} else if (variables.Variables.hunger <= 100 && timer > 500) {
				character.MC.complain();
				timer = 0;
			} else
				timer++;

		}

	}

}
