package enviro;

public class Tree implements Runnable {

	@Override
	public void run() {
		main.World.log("Tree Running");
		while (variables.Variables.isRunning() == true) {
		}
	}
	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Tree");
	}
	public void beEaten() {

	}

	/**
	 * @param args
	 */

}
