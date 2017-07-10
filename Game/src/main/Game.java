package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import controller.Handler;
import controller.KeyManager;
import model.GameState;
import model.MenuState;
import model.State;
import view.Assets;
import view.Camera;
import view.Window;

public class Game implements Runnable {
	private BufferStrategy bs;
	private Graphics graphics;
	private Thread thread;
	private Window window;
	private String title;
	private int width;
	private int height;
	private boolean running = false;
	
	// Input
	private KeyManager keyManager;
	
	//Handler
	private Handler handler;
	
	// Camera 
	private Camera camera;
	
	// States
	private State gameState;
	private State menuState;

	// Constructor
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	// Initialize a new window
	private void init() {
		window = new Window(title, width, height);		// Create the window
		window.getFrame().addKeyListener(keyManager); 	// Allow us to listen for new user keyboard input
		Assets.init();									// Creating and cropping our assets
		camera = new Camera(this, 0,0);					// Creating the game camera
		handler = new Handler(this);
		gameState = new GameState(handler);				// Creating a gameState 
		menuState = new MenuState(handler);				// Creating a menuState
		State.setState(gameState);						// Setting the state as gameState
	}
	
	
	private void tick() {
		keyManager.tick();
		if(State.getState() != null)	// If we are in a known state
			State.getState().tick();	// Calling tick method from current state
	}
	
	// Method that draw our graphics
	private void render() {
		bs = window.getCanvas().getBufferStrategy();		// Get the buffer strategy
		if(bs == null) {
			window.getCanvas().createBufferStrategy(3); 	// If there is no buffer strategy, create one with 3 buffers
			return;
		}
		graphics = bs.getDrawGraphics();					// Get the graphics from our buffer strategy
		graphics.clearRect(0, 0, width, height);			// Clear the screen
		if(State.getState() != null) {						// If we are in a known state
			State.getState().render(graphics);				// Creates graphics with current state render method
		}
		bs.show();											// Display all the graphics on the monitor
		graphics.dispose();									// Mark the graphics variable as usable
	}
	
	// First method of the new thread
	public void run() {
		init();
		int fps = 60;												// Number of time want to execute tick() and render() in 1 second
		double timePerTick = 1000000000 / fps; 						// Maximum time (in nano seconds) we have to execute 1 tick() and 1 render() to execute it 60 time in 1 second
		double delta = 0;								
		long now;										
		long lastTime = System.nanoTime();							// Sets lastTime to the current time in nano seconds
		long timer = 0;
		int ticks = 0;
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;				// Calculate the amount of time computer have until call tick() and render()
			timer += now - lastTime;								// Adding amount of time since we last call our running loop 
			lastTime = now;
			
			if(delta >= 1){											// If delta is OK, we can call tick() and render()
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){								// Checking if timer is running for more than 1 second
				System.out.println("Ticks and Frames: " + ticks);	// Printing number of ticks and frame executed in 1 second
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	// Start the game if not always running
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this); 	// Creating new thread for this game object
		thread.start();			// Launching the run() method
	}
	
	// Stop the game if running
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
