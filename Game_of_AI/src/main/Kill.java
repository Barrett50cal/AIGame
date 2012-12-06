package main;

class Kill implements Runnable {

	public void run() {
		// TODO Auto-generated method stub

		character.MC.kill();
		stats.Hunger.kill();
		stats.Health.kill();

	}
}
