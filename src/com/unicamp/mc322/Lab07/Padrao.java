package com.unicamp.mc322.Lab07;

public abstract class Padrao extends Residencias{
	public static final boolean SIM = true, NAO = false;
	protected int quartos, banheiros;
	
	public Padrao(String name, Position position, double diaria, String code, int quartos, int banheiros) {
		super(name, position, diaria, code);
		this.quartos = quartos;
		this.banheiros = banheiros;
	}
	protected int getBanheiros() {
		return banheiros;
	}
	protected int getQuartos() {
		return quartos;
	}
	public abstract String getPrice();
	public abstract String getPrice(int dias);
}
