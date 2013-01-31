package main;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;

import variables.Variables;

public class World extends Applet implements KeyListener, ActionListener {
	
	private static final long	serialVersionUID	= 7108480780303312481L;
	private static Random		rand				= new Random();
	
	private static Timer		Controller, Controller2;
	
	public static void kill() {
		Controller.stop();
		Controller2.stop();
	}
	
	public static void log(String x) {
		System.out.println(x);
		
	}
	
	private Image		dblImage;
	private Graphics	dblg;
	
	ActionListener		repaintPerformer	= new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent evt) {
													repaint();
												}
											};
	
	ActionListener		movementListener	= new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent evt) {
													if (Variables.isRPress() == true) {
														Variables.setX(Variables.getX() + Variables.speed);
														
													}
													if (Variables.isLPress() == true) {
														Variables.setX(Variables.getX() - Variables.speed);
														
													}
													if (Variables.isDPress() == true) {
														Variables.setY(Variables.getY() + Variables.speed);
														
													}
													if (Variables.isUPress() == true) {
														Variables.setY(Variables.getY() - Variables.speed);
														
													}
												}
											};
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init() {
		variables.Variables.setAlive(true);
		Controller = new Timer(16, repaintPerformer);
		Controller2 = new Timer(5, movementListener);
		Controller.start();
		Controller2.start();
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
			Variables.setRPress(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Variables.setLPress(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Variables.setDPress(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Variables.setUPress(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			if (Math.sqrt(Math.pow(Variables.getX() - variables.Variables.getTreeX(), 2) + Math.pow(Variables.getY() - variables.Variables.getTreeY(), 2)) <= Variables
					.getSize()) {
				Variables.setHunger(variables.Variables.getHunger() + (100 - variables.Variables.getHunger()));
			} else {
				System.out.println("Not in range of tree");
			}
			
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Variables.setRPress(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Variables.setLPress(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Variables.setDPress(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Variables.setUPress(false);
		}
		
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
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if (Variables.isAlive()) {
			g.setColor(Color.red);
			g.drawOval(Variables.getX(), Variables.getY(), 25, 25);
			g.drawRect(0, 370, 100, 20);
		}
		
		g.fillRect(0, 370, Variables.getHealth(), 20);
		
		g.setColor(Color.yellow);
		g.fillRect(280, 370, Variables.getHunger(), 20);
		g.setColor(Color.blue);
		g.fillRect(280, 340, Variables.getSocial(), 20);
		
		g.setColor(Color.green);
		g.fillOval(variables.Variables.getTreeX(), variables.Variables.getTreeY(), Variables.getSize(), Variables.getSize());
		g.setColor(Color.black);
		
		g.drawString("Social", 315, 355);
		g.drawString("Hunger", 315, 385);
		g.drawString("Health", 35, 385);
		
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
}
