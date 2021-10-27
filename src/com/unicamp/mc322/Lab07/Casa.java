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
		double price = this.getDiariaBase() * this.getBanheiros() / this.getQuartos();
		if(piscina && dias < 8)
			price *= (1 + dias);
		else
			price *= dias;		
		return getDecimalFormat().format(price);
	}
	public String getPrice() {
		double price = this.getDiariaBase() * this.getBanheiros() / this.getQuartos();
		if(piscina)
			price *= 2;		
		return getDecimalFormat().format(price);
	}
	public boolean getPiscina() {
		return piscina;
	}
}
//Calcula preço com e sem piscina, até 7 ou mais dias, default (sem dias) - Implementado, não testado