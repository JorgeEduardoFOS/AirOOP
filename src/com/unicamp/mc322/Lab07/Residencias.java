package com.unicamp.mc322.Lab07;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Residencias extends Local{
	private final DecimalFormat df0 = new DecimalFormat(".##");
	private String code;//implementar code
	private double diariaBase;
	
	public Residencias(String name, Position position, double diaria, String code) {
		super(name, position);
		this.diariaBase = diaria;
		this.code = code;
		df0.setRoundingMode(RoundingMode.UP);
	}
	public String getCode() {
		return code;
	}
	public double getDiariaBase() {
		return diariaBase;
	}
	public DecimalFormat getDecimalFormat() {
		return df0;
	}
}
//Falta implementar o identificador