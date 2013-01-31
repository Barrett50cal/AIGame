package main;

class Kill implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		character.MC.kill();
		stats.Hunger.kill();
		stats.Health.kill();
		stats.Social.kill();
		enviro.Tree.kill();
		main.World.kill();
		
	}
	
}
