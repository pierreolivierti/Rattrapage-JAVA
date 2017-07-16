package main;

import javax.swing.JFrame;

import controller.Menu;
import view.Window;

public class Main {
	private static Menu menu;
	private static Window window;
	
	public static void main(String[] args) {
		window = new Window("Setting", 700, 700);
		menu = new Menu();
		while(!menu.isSettingsDone()) { 
			showMenu();
			System.out.println(menu.isSettingsDone());
		}
		if(menu.isSettingsDone()) {
			removeMenu();
			Game game = new Game("Game", 700, 700);
			game.start();
		}
	}
	
	public static void showMenu() {
		if(!menu.isDisplayed()) {
			window.setSize(700, 700);
			window.setContentPane(menu);
			menu.addButton();
			menu.addTitle();
			menu.setDisplayed(true);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button
			menu.repaint();
		}
	}
	
	public static void removeMenu() {
		window.setVisible(false);
		window.dispose();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		Main.menu = menu;
	}
	
}
