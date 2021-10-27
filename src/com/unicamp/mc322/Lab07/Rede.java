package com.unicamp.mc322.Lab07;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Rede {
	private String name, code;
	private double price;
	private DecimalFormat df0 = new DecimalFormat(".##");
	public Rede(String name, String code, double price) {
		this.name = name;
		this.price = price;
		this.code = code;
		df0.setRoundingMode(RoundingMode.UP);
	}
	public String getPrice(int pessoas, int dias){
		if(dias > 5)
			return "0.00";
		else
			return df0.format((double)(pessoas * dias * price));
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public double getPriceBase() {
		return price;
	}
}