package com.game;

import com.engine.Renderer;
import com.engine.gfx.*;;

public class Background {
	private Image image;
	private Image image1;

	public Background(){
		image = new Image("/Underground.png");
		//image1 = new Image("");
	}
	public void Update(Renderer r) {
		r.drawImage(image, 0, 360);
		//r.drawImage(image1, 0, 0);
	}
}
