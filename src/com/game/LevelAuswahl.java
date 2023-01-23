package com.game;

import javax.swing.JLabel;

import com.engine.*;
import com.engine.gfx.*;

public class LevelAuswahl extends AbstractLevel
{
	private Image LE;
	private Image LZ;
	private Image LD;
	private Image UR;
	private Schreiben sch; 
	
	private int Auswahl = 1;
	
	
	
	public LevelAuswahl() {
		
		LE = new Image("/LevelEins.png");
		LZ = new Image("/LevelZwei.png");
		LD = new Image("/LevelDrei.png");
		UR = new Image("/umrandung.png");
		sch = new Schreiben();
		
	}
	public void Update (Renderer r, GameManerger gm ,Switch s, GameContainer gc) {
		
		if(gm.isLinks()&& Auswahl != 1) {
			Auswahl --;
		}
		if(gm.isRechts()&& Auswahl != 3) {
			Auswahl++;
		}
		if(gm.isEnter()) {
			s.Switch(Auswahl + 1);
		}
		r.drawImage(UR, 100 * Auswahl, -25 + Auswahl * 100);
		r.drawImage(LE, 104, 79);
		r.drawImage(LZ, 204, 179);
		r.drawImage(LD, 304, 279);
		
		
		
	}
}
