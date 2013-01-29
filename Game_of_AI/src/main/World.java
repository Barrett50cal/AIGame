package main;

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

public class World extends Applet implements KeyListener, ActionListener {

	private static final long serialVersionUID = 7108480780303312481L;
	private static Random rand = new Random();

	public static boolean keyboardaP;

	public static void log(String x) {
		System.out.println(x);

	}

	private Image dblImage;
	private Graphics dblg;
	

	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			repaint();
		}
	};

	@Override
	public void init() {

		new Timer(50, taskPerformer).start();
		new Thread(new enviro.Tree()).start();
		new Thread(new character.MC()).start();
		Variables.setSize(rand.nextInt(20) + 20);
		variables.Variables.setTreex(rand.nextInt(125) + 50);
		variables.Variables.setTreey(rand.nextInt(125) + 20);
		addKeyListener(this);
		this.setSize(400, 400);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Variables.setKeyboardaP(true);
			Variables.setX(Variables.getX() + Variables.speed);
			// repaint();

		} else {
			Variables.setKeyboardaP(false);
			// repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Variables.setKeyboardaP(true);
			Variables.setX(Variables.getX() - Variables.speed);
			// repaint();

		} else {
			Variables.setKeyboardaP(false);
			// repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Variables.setKeyboardaP(true);
			Variables.setY(Variables.getY() + Variables.speed);
			// repaint();

		} else {
			Variables.setKeyboardaP(false);
			// repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Variables.setKeyboardaP(true);
			Variables.setY(Variables.getY() - Variables.speed);
			// repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Variables.setKeyboardaP(true);
			if (Math.sqrt(Math.pow(
					Variables.getX() - variables.Variables.getTreex(), 2)
					+ Math.pow(
							Variables.getY() - variables.Variables.getTreey(),
							2)) <= Variables.getSize()) {
				Variables.setHunger(variables.Variables.getHunger()
						+ (100 - variables.Variables.getHunger()));
			} else
				System.out.println("Not in range of tree");

		} else {
			Variables.setKeyboardaP(false);
			// repaint();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void loop() {

		if (variables.Variables.isRunning()) {
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.drawOval(Variables.getX(), Variables.getY(), 25, 25);
		g.drawRect(0, 370, 100, 20);

		g.fillRect(0, 370, Variables.getHealth(), 20);
		g.setColor(Color.black);
		g.drawString("Health", 35, 385);

		g.setColor(Color.yellow);
		g.fillRect(280, 370, Variables.getHunger(), 20);
		g.setColor(Color.black);
		g.drawString("Hunger", 310, 385);

		g.setColor(Color.green);
		g.fillOval(variables.Variables.getTreex(),
				variables.Variables.getTreey(), Variables.getSize(), Variables.getSize());

	}

	@Override
	public void stop() {
		new Thread(new main.Kill()).start();
		variables.Variables.setRunning(false);
	}

	@Override
	public void update(Graphics g) {
		if (dblImage == null) {
			dblImage = createImage(this.getSize().width, this.getSize().height);
			dblg = dblImage.getGraphics();
		}

		dblg.setColor(getBackground());
		dblg.fillRect(0, 0, this.getSize().width, this.getSize().height);

		dblg.setColor(getForeground());
		paint(dblg);

		g.drawImage(dblImage, 0, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();

	}
}
