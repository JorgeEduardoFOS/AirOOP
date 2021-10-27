package com.unicamp.mc322.Lab07;

public class Mansao extends Residencias {
	private double area;
	public Mansao(String name, Position position, double diaria, String code, double area) {
		super(name, position, diaria, code);
		this.area = area;
	}
	public String getPrice() {
		return this.getDecimalFormat().format(getDiariaBase());
	}
	public String getPrice(int dias, int pessoas) {
		return getDecimalFormat().format(getDiariaBase() * Math.pow((100 * pessoas / area), dias - 1));	
	}
	public double getArea() {
		return area;
	}
	/////////
	//Teste
	/////////
	public static void main(String[] args) {
		Mansao m1 = new Mansao("Campos Elísios", new Position(23, 56), 124.95, "MA3457", 899.87);
		System.out.println(m1.getCode());
	}

}
// implementado cálculo de preço default e com x dias sem testar