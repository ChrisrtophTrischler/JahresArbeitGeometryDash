package com.game;

import com.engine.Renderer;
import com.engine.gfx.Image;

public class Schreiben {
	
	private int Zahlen;
	
	private int w = 100;
	private Image[] image;
	
	
	public Schreiben() {
		image = new Image [3]; 
		image[1] = new Image ("/null.png");
		image[0] = new Image ("/null.png");
		image[2] = new Image ("/null.png");
		
	
		
	}
 
	
	public void NeueZahl(int Zahl) {
		w = 100;
		for(int i = 0; i < 3; i ++) {
			Zahlen = Zahl / w;
			
			Zahl = Zahl - (w*Zahlen);
			
			w = w / 10;
			
		
			switch(Zahlen){
				case 0:
					image[i]= new Image ("/null.png");
					break;
				case 1:
					image[i] = new Image("/Eins.png");
					break;
				case 2:
					image[i] = new Image("/Zwei.png");
					break;
				case 3:
					image[i] =new Image("/Drei.png");
					break;
				case 4:
					image[i] =  new Image("/Vier.png");
					break;
				case 5:
					image[i] = new Image("/Fümf.png");
					break;
				case 6:
					image[i] = new Image("/Sechs.png");
					break;
				case 7:
					image[i] = new Image("/Sieben.png");
					break;
				case 8:
					image[i] = new Image("/Acht.png");
					break;
				case 9:
					image[i] = new Image("/Neun.png");
					break;
			}
			
			
					
				
			}
		
		}
		public void Schreiben(int X, int Y, Renderer r) {
			for(int i = 0;i< 3; i++ ) {
				r.drawImage(image[i], X + (i* 40), Y);
			}
		}
	}

