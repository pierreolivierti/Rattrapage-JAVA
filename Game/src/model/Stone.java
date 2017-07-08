package model;

import view.Assets;

public class Stone extends Tile {
	
	// Constructor
	public Stone(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
