package stats;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Random;

import javax.swing.Timer;

import variables.Variables;

public class Hunger implements Runnable, ActionListener {

	private static int timer = 0;

	/**
	 * 
	 */
	public static void kill() {
		// TODO Auto-generated method stub
		main.World.log("Killing Hunger");
	}

	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			if (variables.Variables.getHunger() < 1) {
				variables.Variables.setHealth(variables.Variables.getHealth() - 1);
			
			} else if (variables.Variables.getHunger() < 50) {
				character.MC.complain();
				variables.Variables
						.setHunger(variables.Variables.getHunger() - 1);
			} else {
				variables.Variables
						.setHunger(variables.Variables.getHunger() - 1);
			}

		}
	};

	public void run() {
		main.World.log("Hunger Running");
		new Timer(500, taskPerformer).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
