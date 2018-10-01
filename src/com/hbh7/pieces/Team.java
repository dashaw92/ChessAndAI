package com.hbh7.pieces;

public enum Team {
	BLACK, WHITE;
	
	/**
	 * @return The name of the team properly formatted: BLACK -> Black
	 */
	public String getNameProper() {
		return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
	}
}
