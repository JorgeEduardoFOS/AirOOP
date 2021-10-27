package com.unicamp.mc322.Lab07;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Experience extends Local{
	private String code;
	private int maxParticipantes;
	private double priceBase, priceMenor;
	private DecimalFormat df0 = new DecimalFormat(".##");
	public String getCode() {
		return code;
	}
	public Experience(String name, Position position, String code, int maxParticipantes, double priceBase, double priceMenor) {
		super(name, position);
		this.code = code;
		this.position = position;
		this.maxParticipantes = maxParticipantes;
		this.priceBase = priceBase;
		this.priceMenor = priceMenor;
		df0.setRoundingMode(RoundingMode.UP);
	}
	public String getPrice(int totalPessoas, int menorIdade) {
		if(totalPessoas > maxParticipantes) {
			System.out.println("Número de pessoas maior que o permitido.");
			return "0";
		}
		else
			return df0.format((totalPessoas - menorIdade) * priceBase + menorIdade * priceMenor);
	}
	public double getPriceBase() {
		return priceBase;
	}
	public double getPriceMenor() {
		return priceMenor;
	}
}
