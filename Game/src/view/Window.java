package view;

import javax.swing.JFrame;

public class Window {
	private JFrame frame;
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
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}