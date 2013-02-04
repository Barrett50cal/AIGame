package main;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import characters.Character;
import characters.Monster;
import enviro.Tree;

public class World extends Applet implements KeyListener {
	
	private static final long					serialVersionUID	= 7108480780303312481L;
	private static Random						rand				= new Random();
	
	private static characters.Character			MainChar;
	
	private static characters.Character			FriendChar;
	private static List<characters.Character>	CharArray			= new ArrayList<characters.Character>();
	
	private static List<characters.Monster>		MonsterArray		= new ArrayList<characters.Monster>();
	
	private static Timer						Controller, Controller2;
	
	public static Object[] getCharArray() {
		// TODO Auto-generated method stub
		return CharArray.toArray();
	}
	
	/**
	 * @return the charArray
	 */
	public static Character getCharArray(int xfds) {
		return CharArray.get(xfds);
	}
	
	/**
	 * @return the friendChar
	 */
	public static characters.Character getFriendChar() {
		return FriendChar;
	}
	
	/**
	 * @return the mainChar
	 */
	public static characters.Character getMainChar() {
		return MainChar;
	}
	
	/**
	 * @return the monsterArray
	 */
	public static List<characters.Monster> getMonsterArray() {
		return MonsterArray;
	}
	
	public static void kill() {
		Controller.stop();
		
	}
	
	public static void log(String x) {
		System.out.println(x);
		
	}
	
	/**
	 * @param monsterArray
	 *            the monsterArray to set
	 */
	public static void setMonsterArray(List<characters.Monster> monsterArray) {
		MonsterArray = monsterArray;
	}
	
	private Image		dblImage;
	private Graphics	dblg;
	
	ActionListener		repaintPerformer	= new ActionListener() {
												@Override
												public void actionPerformed(
														ActionEvent evt) {
													repaint();
												}
											};
	
	private int			i;
	
	private Monster		MonsterChar;
	
	private void addCharArray(characters.Character newCharToAdd) {
		CharArray.add(newCharToAdd);
	}
	
	private void addMonsterArray(Monster monsterChar2) {
		MonsterArray.add(monsterChar2);
		
	}
	
	@Override
	public void init() {
		
		MainChar = new characters.Character("MC", true, true);
		addCharArray(MainChar);
		
		FriendChar = new characters.Character("Friend", true, true);
		FriendChar.setX(200);
		addCharArray(FriendChar);
		
		MonsterChar = new characters.Monster("Monster", true, true);
		MonsterChar.setX(200);
		MonsterChar.setY(200);
		addMonsterArray(MonsterChar);
		
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
		
		if (MonsterChar != null && MonsterChar.isAlive()) {
			g.setColor(Color.black);
			g.drawOval(MonsterChar.getX(), MonsterChar.getY(), 25, 25);
			
			g.setColor(Color.red);
			
			g.drawRect(0, 340 - 60, 100, 20);
			g.fillRect(0, 340 - 60, MonsterChar.getHealth(), 20);
			
			g.setColor(Color.yellow);
			g.fillRect(280, 310 - 60, MonsterChar.getHunger(), 20);
			g.setColor(Color.blue);
//			g.fillRect(280, 280 - 60, MonsterChar.getSocial(), 20);
			g.setColor(Color.black);
//			g.drawString("Social", 315, 295 - 60);
			g.drawString("Hunger", 315, 325 - 60);
			g.drawString("Health", 35, 355 - 60);
		}
		
		g.setColor(Color.green);
		g.fillOval(Tree.getTreex(), Tree.getTreey(), Tree.getSize(),
				Tree.getSize());
		
	}
	
	/**
	 * @param friendChar
	 *            the friendChar to set
	 */
	public void setFriendChar(characters.Character friendChar) {
		FriendChar = friendChar;
	}
	
	/**
	 * @param mainChar
	 *            the mainChar to set
	 */
	public void setMainChar(characters.Character mainChar) {
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
