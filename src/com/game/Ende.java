package com.game;

import com.engine.gfx.Image;

public class Ende {
	private Image image;
	
	private int Y = 0;
	private int X = 760;
	private int Zeit;//Start Zeit
	private int GK = 0;//GeschwindigKeit
	
	public Ende(int Zeit) {
		this.Zeit = Zeit;
	}
}
