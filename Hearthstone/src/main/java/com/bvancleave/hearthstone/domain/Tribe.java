package com.bvancleave.hearthstone.domain;

public enum Tribe {
	BEAST(0),DEMON(1),DRAGON(2),MURLOC(3),MECH(4);
	
	private int type;
	
	private Tribe( int type ) {
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}

}
