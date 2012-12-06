package main;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import variables.Variables;

public class World implements KeyListener {

	public static void log(String x) {
		System.out.println(x);

	}

	public static void main(String[] args) {
		new Thread(new character.MC()).start();
		while (Variables.isRunning == true)
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		new Thread(new main.Kill()).start();
		variables.Variables.isRunning = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
