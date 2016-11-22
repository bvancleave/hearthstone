package com.bvancleave.hearthstone.domain;

public enum Classes {
	DRUID("Druid", 0),
	HUNTER("Hunter", 1),
	MAGE("Mage", 2),
	PALADIN("Paladin", 3),
	PRIEST("Priest", 4),
	ROGUE("Rogue", 5),
	SHAMAN("Shaman", 6),
	WARLOCK("Warlock", 7),
	WARRIOR("Warrior", 8);
	
	private String name;
	private int type;
	
	private Classes( int type ) {
		this.type = type;
	}
	
	Classes(String name, int type) {
		this.name = name;
		this.type = type;
	}
		
	public String getName() {
		return name;
	}

	public int getType() {
		return this.type;
	}
}
