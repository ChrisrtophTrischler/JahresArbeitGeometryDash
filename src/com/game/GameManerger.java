package com.game;


import com.engine.*;
import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.engine.AbstractGame;
import com.engine.GameContainer;
import com.engine.Renderer;
import com.engine.gfx.*;

public class GameManerger extends AbstractGame
{
	

	private Image image ;
	private Background bg;
	private LevelOne lo;
	private Switch S;
	private int jump  = 0;
	private int Fail = 0;
	private int PauseL = 0;
	private int PauseEnter = 0;
	private int PauseR = 0;
	private boolean Enter = false;
	private boolean links = false;
	private boolean rechts = false;
	
	
	
	
	
	public GameManerger()
	{
	

		bg = new Background();
		lo = new LevelOne();
		image = new Image("/Wasted.png");
		S = new Switch();
		
		
		
		
		
	}

	
	
	public void update(GameContainer gc, float dt)
	{
		
		
		if(gc.getInput().isKey(KeyEvent.VK_SPACE) &&( jump == 0|| jump == 3)) {
				jump = 1;
				
			}
		
		links = false;
		Enter = false;
		rechts = false;
		
		if(PauseEnter == 0) {
			if(gc.getInput().isKey(KeyEvent.VK_ENTER))
			{
				Enter = true;
				PauseEnter = 30;
			}
			
				
			
		}
		else {
			PauseEnter --;
			
		}
		if(PauseL == 0) {
			if(gc.getInput().isKey(KeyEvent.VK_LEFT)||gc.getInput().isKey(KeyEvent.VK_UP))
			{
				links = true;
				PauseL = 15;
			}
			
				
			
		}
		else {
			PauseL--;
			
		}
		if(PauseR == 0) { 
			if(gc.getInput().isKey(KeyEvent.VK_RIGHT)||gc.getInput().isKey(KeyEvent.VK_DOWN)) {
				rechts = true;
				PauseR = 15;
			}
			
				
			
		}
		else {
			PauseR--;
		}
		
	}
	
	
	public void render(GameContainer gc, Renderer r) {
		if(r.getStop() == 1) {
			S.Switch(1);
			r.setStop(0);
		}
		
	     bg.Update(r);
	    // lo.Update(gc, r, this);
	     S.Update(gc, r, this);
	     
	     

		
	}
	public void Stop(Renderer r) {
		r.setStop(1);
	}

	
	public static void main(String args[]) {
		
		GameContainer gc = new GameContainer(new GameManerger());
		gc.start();
	}

	public int getJump() {
		return jump;
	}
	public void setJump(int neu) {
		jump = neu;
	}



	public int getFail() {
		return Fail;
	}



	public void setFail(int fail) {
		Fail = fail;
	}



	public boolean isEnter() {
		return Enter;
	}



	



	public boolean isLinks() {
		return links;
	}



	


	public boolean isRechts() {
		return rechts;
	}
                                                                             
	}







	




