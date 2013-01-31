package enviro;

public class Tree implements Runnable {
	private static int	treex;
	private static int	size;
	private static int	treey;
	
	/**
	 * @return the size
	 */
	public static int getSize() {
		return size;
	}
	
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
	
	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Tree");
	}
	
	/**
	 * @param size
	 *            the size to set
	 */
	public static void setSize(int size) {
		Tree.size = size;
	}
	
	/**
	 * @param treex
	 *            the treex to set
	 */
	public static void setTreex(int treex) {
		Tree.treex = treex;
	}
	
	/**
	 * @param treey
	 *            the treey to set
	 */
	public static void setTreey(int treey) {
		Tree.treey = treey;
	}
	
	public void beEaten() {
		
	}
	
	@Override
	public void run() {
		main.World.log("Tree Running");
	}
	
	/**
	 * @param args
	 */
	
}
