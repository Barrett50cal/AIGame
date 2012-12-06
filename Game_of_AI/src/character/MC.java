package character;

public class MC implements Runnable {

	public static void complain() {
		if (variables.Variables.health < 50) {
			System.out.println("I'm injured.");
		} else if (variables.Variables.hunger < 50) {
			System.out.println("I'm Hungry");
		}

	}

	public static void Die() {
		// TODO Auto-generated method stub
		System.out.println("I died.");

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
