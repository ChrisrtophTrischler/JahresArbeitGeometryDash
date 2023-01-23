package com.engine;

import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.engine.gfx.Image;

public class Renderer 
{
	private int pW, pH;
	private int[] P;
	private int Stop = 0;
	
	
	public Renderer(GameContainer gc) 
	{
		pW = gc.getWidth();
		pH = gc.getHeight();
		P = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear() 
	{
		for(int i = 0; i< P.length;i++) {
			P[i] = 0xffe53030;
		}
	}
	
	public void setPixel(int x, int y, int value)
	{
		if(x < 0||x >= pW||y < 0|| y >= pH || value == 0xffff00ff) {
			return;
		}
		P[x + y *pW] = value;
	}
	public  void drawImage(Image image, int offX,int offY)
	{	
		if(Stop == 0||Stop == 1)
		{
			for(int y = 0;y<image.getH();y++) {
				for(int x = 0;x<image.getW();x++) {
					setPixel(x + offX,y + offY, image.getP()[x + y *image.getW()]);
				}
			}
		}
	}
	

	public int getStop() {
		return Stop;
	}

	public void setStop(int stop) {
		Stop = stop;
	}
}