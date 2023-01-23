package com.game;

import com.engine.GameContainer;
import com.engine.Renderer;
import com.engine.gfx.Image;

public class RespawnScreen extends AbstractLevel{

	
	private Image Wasted;
	private Image Nochmal;
	private Image Levelauswahl;
	private Image auswahl;
	
	private Schreiben sch; 
	
	private int Auswahl = 2;
	
	public RespawnScreen() {
		Wasted = new Image("/Wasted.png");
		Nochmal = new Image("/wiederholen.png");
		Levelauswahl = new Image("/Levelauswahl.png");
		auswahl = new Image("/umrandung.png");
		sch = new Schreiben();
		
	}
	
	public void Update(Renderer r, GameManerger gm, Switch s, GameContainer gc) {
		
		if(gm.isLinks()&& Auswahl != 2) {
			Auswahl--;
		}
		if(gm.isRechts() && Auswahl != 3) {
			Auswahl ++ ;
		}
		if(gm.isEnter()) {
			
			
			if(Auswahl == 2) {
				s.Switch(s.getLastlevel());
			}
			else {                                              
				s.Switch(0);                          
			}       
		}                       
		r.drawImage(Wasted, 10, 10);                                           
		r.drawImage(auswahl, 100 * Auswahl, -25 + Auswahl * 100);                 
		r.drawImage(Nochmal, 204, 179);
		r.drawImage(Levelauswahl, 304, 279);
		sch.Schreiben( 20, 150, r);
	}
}
