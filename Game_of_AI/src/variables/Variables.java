package variables;

public abstract class Variables {
	public static final int	speed		= 1;
	
	private static int		health		= 100;
	
	private static int		hunger		= 100;
	
	private static boolean	isRunning	= true;
	
	private static int		x			= 0, y = 0;
	
	private static boolean	keyboardaP;
	
	private static int		treex;
	
	private static int		treey;
	
	private static int		size;
	
	private static int		social		= 100;
	
	private static boolean	UPress, DPress, LPress, RPress;
	
	private static boolean	isAlive;
	
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
	
	public static int getSize() {
		return size;
	}
	
	public static int getSocial() {
		return social;
	}
	
	/**
	 * @return the treex
	 */
	public static int getTreeX() {
		return treex;
	}
	
	/**
	 * @return the treey
	 */
	public static int getTreeY() {
		return treey;
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
	 * @return the isAlive
	 */
	public static boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * @return the dPress
	 */
	public static boolean isDPress() {
		return DPress;
	}
	
	/**
	 * @return the keyboardaP
	 */
	public static boolean isKeyboardaP() {
		return keyboardaP;
	}
	
	/**
	 * @return the lPress
	 */
	public static boolean isLPress() {
		return LPress;
	}
	
	/**
	 * @return the rPress
	 */
	public static boolean isRPress() {
		return RPress;
	}
	
	/**
	 * @return the isRunning
	 */
	public static boolean isRunning() {
		return isRunning;
	}
	
	/**
	 * @return the uPress
	 */
	public static boolean isUPress() {
		return UPress;
	}
	
	/**
	 * @param isAlive
	 *            the isAlive to set
	 */
	public static void setAlive(boolean isAlive) {
		Variables.isAlive = isAlive;
	}
	
	/**
	 * @param dPress
	 *            the dPress to set
	 */
	public static void setDPress(boolean dPress) {
		DPress = dPress;
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
	 * @param keyboardaP
	 *            the keyboardaP to set
	 */
	public static void setKeyboardaP(boolean keyboardaP) {
		Variables.keyboardaP = keyboardaP;
	}
	
	/**
	 * @param lPress
	 *            the lPress to set
	 */
	public static void setLPress(boolean lPress) {
		LPress = lPress;
	}
	
	/**
	 * @param rPress
	 *            the rPress to set
	 */
	public static void setRPress(boolean rPress) {
		RPress = rPress;
	}
	
	/**
	 * @param isRunning
	 *            the isRunning to set
	 */
	public static void setRunning(boolean isRunning) {
		Variables.isRunning = isRunning;
	}
	
	public static void setSize(int size) {
		Variables.size = size;
	}
	
	public static void setSocial(int social) {
		Variables.social = social;
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
	
	/**
	 * @param uPress
	 *            the uPress to set
	 */
	public static void setUPress(boolean uPress) {
		UPress = uPress;
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
}
