package variables;

public abstract class Priorities {
	private int		curPriority;
	private String	task;
	
	public Priorities() {
		switch (curPriority) {
			case 1:
				task = "Eat";
				break;
			case 2:
				task = "Socialize";
				break;
			default:
				break;
		}
	}
}