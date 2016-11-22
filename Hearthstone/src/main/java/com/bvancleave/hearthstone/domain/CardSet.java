package com.bvancleave.hearthstone.domain;

public enum CardSet {
	CORE("Classic", 0), 
	GVG("Goblins vs Gnomes", 1),
	NAXX("Naxxramus", 2),
	TGT("The Grand Tourament", 3),
	BRM("Blackrock Mountain", 4),
	LOE("League of Explorers", 5),
	WOG("Whispers of the Old Gods", 6),
	KARA("One Night in Karazhan", 7),
	TB("",8),
	HERO_SKINS("Hero Skins", 9);
	
	private String name;
	private int type;
	
	CardSet( String name, int type ) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getType() {
		return this.type;
	}
}
