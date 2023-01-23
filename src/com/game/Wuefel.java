package com.game;

import com.engine.*;
import com.engine.gfx.Image;

public class Wuefel {
	private Image image;
	private int Y = 300;
	private int X = 200;
	private int lastY = 0;
	private double höheY = 300;
	private int springen = 0;
	private int sprung = 0;
	private int[] PX;//Punkte X
	private int[] PY;
	
	public Wuefel() {
		
		image = new Image("/wurfel.png");
		PX = new int[2];
		PY = new int[2];
		
	}
 
	public void Update(Renderer r,GameManerger gm, GameContainer gc) {
		
		PX[0] = X;
		PX[1] = X + 60;
		
		PY[0] = Y;
		PY[1] = Y + 60;
		
		
			
			if(gm.getJump() == 1) 
			{
				lastY = Y ;
				
				gm.setJump(4);
			}
			
			if(gm.getJump() == 4 && gc.getFps() > 0) {
				springen = (int)(190 / ((gc.getFps()) / 2 ));	
				höheY = höheY - springen;
				
			}
			else {
				if(gm.getJump() == 2 && gc.getFps() > 0) {
				
				springen = (int)(190 / ((gc.getFps())/2));
				höheY = höheY + springen;
			
				}
				if(höheY >= 300) {
					gm.setJump(0);
				}  
			}
			
			if( gm.getJump() == 4 && Y < lastY - 120 && Y > lastY - 130) {
				gm.setJump(2);
			}
			
			
		
		
		
		
		
		Y = (int)(höheY);
		r.drawImage(image, X, Y);
	
		
		
	}

	public int[] getPX() {
		return PX;
	}

	public int[] getPY() {
		return PY;
	}

	

	public void setHöheY(double höheY) {
		this.höheY = höheY;
	}
}
