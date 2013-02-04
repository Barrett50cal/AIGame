package helpers;

import characters.Monster;

public class Utils {
	
	public static Double getDistance(characters.Character target, Monster local) {
		return Math.sqrt(Math.pow(target.getX() - local.getX(), 2) + Math.pow(target.getY() - local.getY(), 2));
	}
	
	public static Double getDistance(int targetX, int targetY, int localX, int localY) {
		return Math.sqrt(Math.pow(targetX - localX, 2) + Math.pow(targetY - localY, 2));
	}
}
