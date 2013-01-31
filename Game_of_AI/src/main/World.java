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

import enviro.Tree;

public class World extends Applet implements KeyListener {
	
	private static final long			serialVersionUID	= 7108480780303312481L;
	private static Random				rand				= new Random();
	
	private static character.Character	MainChar;
	
	private static character.Character	FriendChar;
	private static Timer				Controller, Controller2;
	
	/**
	 * @return the friendChar
	 */
	public static character.Character getFriendChar() {
		return FriendChar;
	}
	
	/**
	 * @return the mainChar
	 */
	public static character.Character getMainChar() {
		return MainChar;
	}
	
	public static void kill() {
		Controller.stop();
		
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
	
	@Override
	public void init() {
		
		MainChar = new character.Character("MC", true, true);
		MainChar.setAlive(true);
		
		FriendChar = new character.Character("Friend", true, true);
		FriendChar.setAlive(true);
		FriendChar.setX(200);
		Controller = new Timer(16, repaintPerformer);
		Controller.start();
		new Thread(new enviro.Tree()).start();
		Tree.setSize(rand.nextInt(20) + 20);
		Tree.setTreex(rand.nextInt(125) + 50);
		Tree.setTreey(rand.nextInt(125) + 20);
		addKeyListener(this);
		this.setSize(400, 400);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_D) {
//			MainChar.setRPress(true);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_A) {
//			MainChar.setLPress(true);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_S) {
//			MainChar.setDPress(true);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_W) {
//			MainChar.setUPress(true);
//		}		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			MainChar.setRPress(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			MainChar.setLPress(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			MainChar.setDPress(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			MainChar.setUPress(false);
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paint(Graphics g) {
		if (MainChar != null && MainChar.isAlive()) {
			g.setColor(Color.red);
			g.drawOval(MainChar.getX(), MainChar.getY(), 25, 25);
			
			g.setColor(Color.red);
			g.drawRect(0, 370, 100, 20);
			g.fillRect(0, 370, MainChar.getHealth(), 20);
			
			g.setColor(Color.yellow);
			g.fillRect(280, 370, MainChar.getHunger(), 20);
			g.setColor(Color.blue);
			g.fillRect(280, 340, MainChar.getSocial(), 20);
			g.setColor(Color.black);
			g.drawString("Social", 315, 355);
			g.drawString("Hunger", 315, 385);
			g.drawString("Health", 35, 385);
		}
		
		if (FriendChar != null && FriendChar.isAlive()) {
			g.setColor(Color.black);
			g.drawOval(FriendChar.getX(), FriendChar.getY(), 25, 25);
			
			g.setColor(Color.red);
			
			g.drawRect(0, 340, 100, 20);
			g.fillRect(0, 340, FriendChar.getHealth(), 20);
			
			g.setColor(Color.yellow);
			g.fillRect(280, 310, FriendChar.getHunger(), 20);
			g.setColor(Color.blue);
			g.fillRect(280, 280, FriendChar.getSocial(), 20);
			g.setColor(Color.black);
			g.drawString("Social", 315, 295);
			g.drawString("Hunger", 315, 325);
			g.drawString("Health", 35, 355);
		}
		
		g.setColor(Color.green);
		g.fillOval(Tree.getTreex(), Tree.getTreey(), Tree.getSize(), Tree.getSize());
		
	}
	
	/**
	 * @param friendChar
	 *            the friendChar to set
	 */
	public void setFriendChar(character.Character friendChar) {
		FriendChar = friendChar;
	}
	
	/**
	 * @param mainChar
	 *            the mainChar to set
	 */
	public void setMainChar(character.Character mainChar) {
		MainChar = mainChar;
	}
	
	@Override
	public void stop() {
		new Thread(new main.Kill()).start();
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
