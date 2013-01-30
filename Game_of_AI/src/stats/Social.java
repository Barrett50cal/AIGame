package stats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Social implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			if (variables.Variables.getSocial() < 1) {
				variables.Variables
						.setHealth(variables.Variables.getHealth() - 1);
				character.MC.complain();
			} else if (variables.Variables.getSocial() < 50) {
				character.MC.complain();
				variables.Variables
						.setSocial(variables.Variables.getSocial() - 2);
			} else {
				variables.Variables
						.setSocial(variables.Variables.getSocial() - 2);
			}

		}
	};

	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Social");
	}
}
