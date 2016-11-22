package com.bvancleave.hearthstone.domain;

public enum MechanicType {
	BATTLECRY(0), TAUNT(1), JOUST(2), CHARGE(3), DISCOVER(4);
	
	private int type;
	
	private MechanicType( int type ) {
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}
}
