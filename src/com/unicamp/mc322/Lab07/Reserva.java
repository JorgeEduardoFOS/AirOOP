package com.unicamp.mc322.Lab07;

public class Reserva {
	private int totalPessoas, pessoasMenores, dias;
	private String code;

	public Reserva(String code, int totalPessoas, int pessoasMenores, int dias) {
		this.code = code;
		this.totalPessoas = totalPessoas;
		this.pessoasMenores = pessoasMenores;
		this.dias = dias;
	}
	public int getPessoas() {
		return totalPessoas;
	}
	public int getPessoasMenores() {
		return pessoasMenores;
	}
	public int getDias() {
		return dias;
	}
	public String getCode() {
		return code;
	}
}