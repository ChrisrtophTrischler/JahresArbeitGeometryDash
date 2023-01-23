package com.game;

import com.engine.Renderer;
import com.engine.gfx.Image;

public class Dreieck {
	private Image image;
	private int Y = 0;
	private int X = 1000;
	private int Zeit;//Start Zeit
	private int PX[];//Punkte X/Y
	private int PY[];
	private int GK = 0;//GeschwindigKiet

	public Dreieck(double Höhe, int Z , int G)
	{
		image = new Image("/dreieck.png");
		
		
		Zeit = Z;
		Y = (int)(300 - (Höhe*60));
		PX = new int[3];
		PY = new int[2];
		GK = G;
	}
	public void Update(Renderer r, LevelOne lo, GameManerger gm,Wuefel wuefel) {
		if(X > 0&&X < 760) {
			
			PX[0] = X + 1;
			PX[1] = X + 30;
			PX[2] = X + 59;
			PY[0] = Y + 1;
			PY[1] = Y + 59;
			
			if(wuefel.getPX()[0] < PX[0] && wuefel.getPX()[1] > PX[0]) {
				
				if(wuefel.getPY()[0] < PY[1] && wuefel.getPY()[1] > PY[1]) {
					gm.Stop(r);
				}
				
			}
			else if(wuefel.getPX()[0] < PX[1] && wuefel.getPX()[1] > PX[1]) {
				
				if(wuefel.getPY()[0] < PY[0] && wuefel.getPY()[1] > PY[0]) {
					gm.Stop(r);
				}
			}
			else if(wuefel.getPX()[0] < PX[2] && wuefel.getPX()[1] > PX[2]) {
				
				if(wuefel.getPY()[0] < PY[1]&& wuefel.getPY()[1] > PY[1]) {
					gm.Stop(r);
				}
			}
			
		}
		r.drawImage(image, X, Y);
		
		if(Zeit < lo.getZeit()) {
			X = X - GK;
		}
		

		
	}
	public void reset() {
		X = 760;

	}
}
