package stats;

public class Health implements Runnable {

	private static int timer;

	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Health");
	}

	public Health() {
		main.World.log("Health Running");
		while (variables.Variables.isRunning() == true) {
			if (variables.Variables.getHealth() == 0) {
				character.MC.Die();
			} else if (variables.Variables.getHealth() <= 100 && timer > 10) {
				character.MC.complain();
				timer = 0;
			} else {
				timer++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
