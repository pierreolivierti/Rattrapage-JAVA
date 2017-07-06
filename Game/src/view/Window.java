package view;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;


public class Window {
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width;
	private int height;
	
	// Constructor
	public Window(String title, int width, int height) {
		this.title = title;
		this.height = height;
		this.width = width;
		createWindow();
	}
	
	// Create a window with different params
	public void createWindow() {
		frame = new JFrame(title);
		frame.setSize(width, height); 						  // Window size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button
		frame.setResizable(false); 							  // Window not resizable
		frame.setLocationRelativeTo(null); 					  // Display window in center
		frame.setVisible(true); 							  // Make the window visible
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height)); //////////////////////////////////////////
		canvas.setMaximumSize(new Dimension(width, height));   // Keep the canvas always the same size //
		canvas.setMinimumSize(new Dimension(width, height));   //////////////////////////////////////////
		canvas.setFocusable(false);
		frame.add(canvas); 									   // Add the canvas to the frame
		frame.pack();
	}
	
	// Get canvas
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}