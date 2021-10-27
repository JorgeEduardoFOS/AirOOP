package com.unicamp.mc322.Lab07;

public abstract class Local {
	protected String name;
	protected Position position;
	public Local(String name, Position position) {
		this.name = name;
		this.position = position;
	}
	public Position getPosition() {
		return position;
	}
	public String getName() {
		return name;
	}
}
