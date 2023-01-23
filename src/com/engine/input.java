package com.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class input implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener 
{
	private final int NUM_KEYS = 256;
	private boolean[] keys = new boolean[NUM_KEYS];	
	private boolean[] keysLast = new boolean[NUM_KEYS];
	
	private final int NUM_Buttons = 5;
	private boolean[] buttons = new boolean[NUM_Buttons];	
	private boolean[] buttonsLast = new boolean[NUM_Buttons];
	
	private int mouseX, mouseY;
	private int scroll ;
	private GameContainer gc;
	
	public input(GameContainer gc) {
		this.gc = gc;
		mouseX =0;
		mouseY = 0;
		scroll = 0;
		
		gc.getWindow().getCanvas().addKeyListener(this);
		gc.getWindow().getCanvas().addMouseMotionListener(this);
		gc.getWindow().getCanvas().addMouseListener(this);
		gc.getWindow().getCanvas().addMouseWheelListener(this);
	}
	public void update()
	{
		scroll = 0;
		
		for(int i = 0; i< NUM_KEYS;i++) {
			keysLast[i] = keys[1];
		}
		for(int i = 0; i< NUM_Buttons;i++) {
			buttonsLast[i] = buttons[1];
		}
	
	}
	public boolean isKey(int keyCode) {
		
		return keys[keyCode];
	
	}
	public boolean isKeyUp(int keyCode) {
		return !keys[keyCode] && keys[keyCode];
	}
	public boolean isKeyDown(int keyCode) {
		
		return keys[keyCode] && keysLast[keyCode];
	}
	public boolean isButton(int ButtonCode) {
		return buttons[ButtonCode];
	}
	public boolean isButtonUp(int ButtonCode) {
		return !buttons[ButtonCode] && buttonsLast[ButtonCode];
	}
	public boolean isButtonDown(int ButtonCode) {
		return buttons[ButtonCode] && buttonsLast[ButtonCode];
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		mouseX = (int)(e.getX() / gc.getScale());
		mouseY = (int)(e.getY() / gc.getScale());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = (int)(e.getX() / gc.getScale());
		mouseY = (int)(e.getY() / gc.getScale());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		scroll = e.getWheelRotation();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		buttons[e.getButton()] = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public int getMouseX() {
		return mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
	public int getScroll() {
		return scroll;
	}
	
}
