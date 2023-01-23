package com.game;

import com.engine.*;

public class LevelOne extends AbstractLevel{
	private Wuefel wuefel;
	private Kiste[] kiste;
	private Dreieck[] dreieck;
	private int Zeit = 0;
	private double miliSek = 0;
	private double Sek = 0;
	private int GK = 4;//Geschwindigkeit
	
	private int dreiecke = 1;
	private int kisten = 2;
	private double[] Hoehen;
	private int[] SZeiten;//StartZeiten
	
	public LevelOne() {
		wuefel = new Wuefel();
		Hoehen = new double []{0 , 1, 0};
		SZeiten = new int [] {1, 30 , 120};
		dreieck = new Dreieck[dreiecke];
		kiste = new Kiste[kisten];
		
		for(int i = 0; i < kisten;i++) {
			kiste[i] = new Kiste(Hoehen[i],SZeiten[i],GK);
		}
		
		for(int i = 0; i < dreiecke; i ++) {
			dreieck[i] = new Dreieck(Hoehen[i+kisten],SZeiten[i+kisten],GK);
		}
	}
	
	public void Update(Renderer r, GameManerger gm, Switch s, GameContainer gc) {
		
		int B = 0;
		for(int i = 0; i < kisten; i++) {
			B = B + kiste[i].getB();
		}	
		if(gc.getFps() > 0)
		{
			miliSek = (60 / gc.getFps() );
		}
		Sek = Sek + miliSek;
		
		Zeit = (int)(Sek);
		for(int i = 0; i < kisten; i ++) {
			kiste[i].Update(r, this, gm, wuefel, B);
		}
		
		for(int i = 0; i < dreiecke; i++) {
			dreieck[i].Update(r, this, gm, wuefel);
		}
		wuefel.Update(r, gm, gc);
		
	}
	

	public int getZeit() {
		return Zeit;
	}

	

	

	

	
	
}
