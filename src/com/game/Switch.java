package com.game;
import com.engine.*;


public class Switch {
	
	private AbstractLevel L;
	
	
	private int lastlevel;
	
	public Switch() {
		L = new LevelAuswahl();
		
		
	}
	public void Update(GameContainer gc, Renderer r, GameManerger gm) {
		
		L.Update(r, gm, this, gc);
	}
	
	public void Switch(int Level) {
		switch (Level) {
		case 0:
			L = new LevelAuswahl();
			break;
		case 1: 
			L = new RespawnScreen();
			break;
		case 2: 
			L = new LevelOne();
			lastlevel = 2;
			break;
		case 3:
			//LT.Update(gc, r, gm);
			lastlevel = 3;
			break;
		case 4:
			//LD.Update(gc, r, gm);
			lastlevel = 4;
			break;
			
		}
	}
	
	
	
	public int getLastlevel() {
		return lastlevel;
	}

}
