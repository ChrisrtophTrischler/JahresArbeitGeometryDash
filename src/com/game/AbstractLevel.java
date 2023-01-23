package com.game;

import com.engine.GameContainer;
import com.engine.Renderer;

public abstract class AbstractLevel {
	
	public abstract void Update(Renderer r, GameManerger gm ,Switch s, GameContainer gc); 
	
}