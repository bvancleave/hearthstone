package com.bvancleave.hearthstone.domain;

public enum Rarity {
	COMMON(0), RARE(1), EPIC(2), LEGENDARY(3), FREE(4);
	
	private int type;
	
	private Rarity( int type ) {
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}

}
