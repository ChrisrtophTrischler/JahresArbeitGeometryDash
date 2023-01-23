package com.game;

import com.engine.Renderer;
import com.engine.gfx.*;

public class Kiste {
	private Image image;
	
	private int Y = 0;
	private int X = 1000;
	private int Zeit;//Start Zeit
	private int PX[];//Punkte X/Y
	private int PY[];
	private int GK = 0;//GeschwindigKiet
	private int B = 0;//Besetzt
	private int Bs = 0;//ob andere Bestzt sind
	private int BB = 0;
	private double Höhe = 0;
	
	
	
	public Kiste(double Höhe, int z ,int G) {
		image = new Image("/Kiste.png");
		
		Zeit = z;
		Y = (int)((300 - (Höhe*60)));
		this.Höhe = Höhe;
		PX = new int[2];
		PY = new int[3];
		GK = G;
	}	
		
	
	
	public  void Update(Renderer r, LevelOne lo, GameManerger gm,Wuefel wuefel, int Bi) 
	{
		if(X > 0&&X < 1000) {
		
		
		BB = 0;
		
		Bs = Bi - B;
		
		PX[0] = X + 1;
		PX[1] = X + 59;


		PY[0] = Y + 5;
		PY[1] = Y + 59;
		PY[2] = Y;
		
		
		
		if(wuefel.getPY()[1] <= PY[2]+10 && wuefel.getPY()[1] >= PY[2] - 10) {
		if(PX[0] <= wuefel.getPX()[0] && wuefel.getPX()[0] <= PX[1] && (gm.getJump()==2||gm.getJump()==3)) 
		{   
			
			gm.setJump(3);
			B = 1;
			BB = 1;
			wuefel.setHöheY(240 - (Höhe* 60));
		}
		else if(gm.getJump() == 3) {
			
			B = 0;
			BB = 0;
			
			if(Bs == 0) {
				gm.setJump(2);
			}
		}

		 if(PX[0] <= wuefel.getPX()[1] && wuefel.getPX()[1] <= PX[1] &&( gm.getJump() == 2 || gm.getJump() == 3))
		{

			gm.setJump(3);
			B = 1;
			wuefel.setHöheY(240 - (Höhe* 60));
		}
		else if(gm.getJump() == 3) {
			
				if(BB != 1) {
					B = 0;
				
					if(Bs == 0) {
					gm.setJump(2);
					}
				}	
			}
			
				
		
		
		else if(gm.getJump() == 3) {
			
			B = 0;
			
			if(Bs == 0) {
				gm.setJump(2);
			}
		}

		}
		if(B == 0) {
		if(wuefel.getPX()[0]<PX[1]&&wuefel.getPX()[1]>PX[1]) {

			if(wuefel.getPY()[0]<PY[1]&&wuefel.getPY()[1]>PY[1]) {
			
				
				gm.Stop(r);
			}

			else if(wuefel.getPY()[0] < PY[0]&&wuefel.getPY()[1] > PY[0]) {
				
				gm.Stop(r);
			}
		}
		else if(wuefel.getPX()[0]<PX[0]&&wuefel.getPX()[1]>PX[0]) {
			

			if(wuefel.getPY()[0]<PY[0]&&wuefel.getPY()[1]>PY[0]) {
			
				
				gm.Stop(r);
			}
			

			else if(wuefel.getPY()[0] < PY[1]&&wuefel.getPY()[1] > PY[1]) {
				
				gm.Stop(r);
			}




			
		}
			
		}
		}
			
		
			r.drawImage(image, X, Y);
		if(Zeit < lo.getZeit()) {
			
			X = X - GK;
		}
		else { System.out.println(lo.getZeit());
		}
		
	}
	
	
		

	public int getB() {
		return B;
	}

	

}

