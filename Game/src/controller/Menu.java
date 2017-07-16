package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private static final long serialVersionUID = -8057234139158305192L;
	private boolean isDisplayed = false;
	private boolean settingsDone = false;
	
	public Menu() {
	}
	
	public void addTitle(){
		Font font = new Font("Snap ITC", Font.BOLD, 50);
		JLabel titre = new JLabel();
		titre.setForeground(Color.red);
		titre.setFont(font); 
		titre.setText("Welcome!");
		this.add(titre);
	}
	
	public void addButton() {
		JButton playButton = new JButton("Play");
		JButton exitButton = new JButton("Exit");
		JCheckBox random = new JCheckBox("Aleatoire");
		JCheckBox intel = new JCheckBox("Intelligent");
		JLabel texte = new JLabel();
		JLabel texte2 = new JLabel();
		texte.setText("Se deplacer avec les fleches.");
		texte2.setText("W : attaque en haut - A : attaque a gauche - S : attaque en bas - D : attaque a droite");
		playButton.addActionListener(new PlayButton(this));
		exitButton.addActionListener(new ExitButton(this));
		random.addActionListener(new TickRandom());
		intel.addActionListener(new TickIntel());
		Box HBox = Box.createHorizontalBox();
		Box VBox = Box.createVerticalBox();
		HBox.add(random);
		HBox.add(intel);
		HBox.add(playButton);
		VBox.add(texte);
		VBox.add(texte2);
		this.add(HBox);
		this.add(VBox);
	}

	public boolean isDisplayed() {
		return isDisplayed;
	}

	public void setDisplayed(boolean isDisplayed) {
		this.isDisplayed = isDisplayed;
	}

	public boolean isSettingsDone() {
		return settingsDone;
	}

	public void setSettingsDone(boolean settingsDone) {
		this.settingsDone = settingsDone;
	}
}

class ExitButton implements ActionListener  {
	private Menu menu;
	public ExitButton(Menu menu) {
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		menu.setSettingsDone(true);
	}
}

class PlayButton implements ActionListener  {
	private Menu menu;
	public PlayButton(Menu menu) {
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		menu.setSettingsDone(true);
	}
}

class TickRandom implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Random");
	}
}

class TickIntel implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Intel");
	}
}
