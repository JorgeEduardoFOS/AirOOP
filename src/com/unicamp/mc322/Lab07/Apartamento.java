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
		double price = this.getDiariaBase() * (1 + andar * 0.01);
		if(sacada)
			price *= (dias + 1);
		else
			price *= dias;
		return this.getDecimalFormat().format(price);
	}
	public String getPrice() {
		double price = this.getDiariaBase() * (1 + andar * 0.01);
		if(sacada)
			price *= 2;
		return this.getDecimalFormat().format(price);
	}
	public boolean getSacada() {
		return sacada;
	}
}
//Calcula preço default, calcula preço diárias, sacada, andar - Implementado, não testado
//Construtores sem sacada, com sacada - Implementado, não testado