package com.unicamp.mc322.Lab07;

public class Apartamento extends Padrao {
	private int andar;
	private boolean sacada;
	public Apartamento(String name, Position position, double diaria, String code, int quartos, int banheiros, int andar) {
		super(name, position, diaria, code, quartos, banheiros);
		this.andar = andar;
	}
	public Apartamento(String name, Position position, double diaria, String code, int quartos, int banheiros, int andar, boolean sacada) {
		this(name, position, diaria, code, quartos, banheiros, andar);
		this.sacada = sacada;
	}
	public String getPrice(int dias) {
		double price = diariaBase * (1 + andar * 0.01);
		if(sacada)
			price *= (dias + 1);
		else
			price *= dias;
		return df0.format(price);
	}
	public String getPrice() {
		double price = diariaBase * (1 + andar * 0.01);
		if(sacada)
			price *= 2;
		return df0.format(price);
	}
	public boolean getSacada() {
		return sacada;
	}
}
