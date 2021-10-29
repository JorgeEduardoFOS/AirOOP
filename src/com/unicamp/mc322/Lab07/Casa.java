package com.unicamp.mc322.Lab07;

public class Casa extends Padrao {
	private boolean piscina;
	public Casa(String name, Position position, double diaria, String code, int quartos, int banheiros) {
		super(name, position, diaria, code, quartos, banheiros);
	}
	public Casa(String name, Position position, double diaria, String code, int quartos, int banheiros, boolean piscina) {
		super(name, position, diaria, code, quartos, banheiros);
		this.piscina = piscina;
	}
	public String getPrice(int dias) {
		double price = diariaBase * banheiros / quartos;
		if(piscina && dias < 8)
			price *= (1 + dias);
		else
			price *= dias;		
		return df0.format(price);
	}
	public String getPrice() {
		double price = diariaBase * banheiros / quartos;
		if(piscina)
			price *= 2;		
		return df0.format(price);
	}
	public boolean getPiscina() {
		return piscina;
	}
}
