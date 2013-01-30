package variables;

public abstract class Variables {
	/**
	 * @return the health
	 */
	public static int getHealth() {
		return health;
	}

	/**
	 * @return the hunger
	 */
	public static int getHunger() {
		return hunger;
	}

	/**
	 * @return the isRunning
	 */
	public static boolean isRunning() {
		return isRunning;
	}

	/**
	 * @return the x
	 */
	public static int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public static int getY() {
		return y;
	}

	/**
	 * @return the keyboardaP
	 */
	public static boolean isKeyboardaP() {
		return keyboardaP;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public static void setHealth(int health) {
		Variables.health = health;
	}

	/**
	 * @param hunger
	 *            the hunger to set
	 */
	public static void setHunger(int hunger) {
		Variables.hunger = hunger;
	}

	/**
	 * @param isRunning
	 *            the isRunning to set
	 */
	public static void setRunning(boolean isRunning) {
		Variables.isRunning = isRunning;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public static void setX(int x) {
		Variables.x = x;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public static void setY(int y) {
		Variables.y = y;
	}

	/**
	 * @param keyboardaP
	 *            the keyboardaP to set
	 */
	public static void setKeyboardaP(boolean keyboardaP) {
		Variables.keyboardaP = keyboardaP;
	}

	public static final int speed = 4;
	private static int health = 100;
	private static int hunger = 100;
	private static boolean isRunning = true;
	private static int x = 0, y = 0;
	private static boolean keyboardaP;
	private static int treex;
	private static int treey;
	private static int size;
	private static int social = 100;

	/**
	 * @return the treex
	 */
	public static int getTreex() {
		return treex;
	}

	/**
	 * @return the treey
	 */
	public static int getTreey() {
		return treey;
	}

	/**
	 * @param treex
	 *            the treex to set
	 */
	public static void setTreex(int treex) {
		Variables.treex = treex;
	}

	/**
	 * @param treey
	 *            the treey to set
	 */
	public static void setTreey(int treey) {
		Variables.treey = treey;
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Variables.size = size;
	}

	public static int getSocial() {
		return social;
	}

	public static void setSocial(int social) {
		Variables.social = social;
	}
}
