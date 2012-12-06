package stats;

public class Health implements Runnable {

	private static int timer;

	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Health");
	}

	public Health() {
		main.World.log("Health Running");
		while (variables.Variables.isRunning == true) {
			if (variables.Variables.health == 0) {
				character.MC.Die();
			} else if (variables.Variables.health <= 100 && timer > 500) {
				character.MC.complain();
				timer = 0;
			} else
				timer++;

		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
