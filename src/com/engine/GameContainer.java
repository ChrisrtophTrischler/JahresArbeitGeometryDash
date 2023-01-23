package com.engine;

import javax.swing.JLabel;

public class GameContainer implements Runnable
{
	private Thread thread;
	private Window window;
	private input input;
	
	private AbstractGame game;
	private boolean running = false;
	private Renderer renderer;
	private final double UPDATE_CAP = 1.0/60.0;
	private int width = 1000, height = 400;
	private float scale = 1.5f;
	private String title = "GeoThrash";
	private 	int fps = 0;
	 
	
	public GameContainer(AbstractGame game)
	{
		this.game = game;
	}
	
	public void start()
	{
    window = new Window(this);
    renderer = new Renderer(this);
    input = new input(this);

	thread = new Thread((Runnable) this);
	thread.run(); 
	}
	
    public void Stop() 
    {
    	
    }
    
    public void run() 
    {
    	
    	running = true; 
    	
    	boolean render = false; 
    	double firstTime = 0; 
    	double lastTime = System.nanoTime() / 1000000000.0;
    	double passedTime = 0;
    	double unprocessedTime = 0;
    	
    	double frameTime = 0;
    	int frames = 0;
    
    	 
    		
    	
    	while(running)
    	{
    		render = false; 
    		firstTime = System.nanoTime() / 1000000000.0;  
    		passedTime = firstTime - lastTime;
    		lastTime = firstTime;
    		
    		unprocessedTime += passedTime;
    		frameTime += passedTime;
    		
    		
    		while (unprocessedTime >= UPDATE_CAP)
            {
    			unprocessedTime -= UPDATE_CAP;
    			render = true; 
    			
    			
				game.update(this, (float)UPDATE_CAP);
    			input.update();
    			
    			if (frameTime >= 1.0) 
    			{
    				frameTime = 0;
    				fps = frames;
    				frames = 0;
    				System.out.println(fps);
    				
    				
    			}
    		}
    		
    		if(render) {
    			renderer.clear();
    		game.render(this, renderer);
    			window.update();
    			frames++; 
    		}
    		
    		else {
    			
    			try
    			{
    				Thread.sleep(1);
    			}
    			
    			catch (InterruptedException e)
    		    {
    				e.printStackTrace();
    			}
    		
    		}

    	}
    }
    
    public void Label(JLabel label) {
    	window.Label(label);
    }
    public void dispose() {
    	
    }
    
 
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Window getWindow() {
		return window;
	}

	public input getInput() {
		return input;
	}

	public int getFps() {
		return fps;
	}
}

