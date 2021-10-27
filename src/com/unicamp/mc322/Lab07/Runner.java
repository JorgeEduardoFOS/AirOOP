package com.unicamp.mc322.Lab07;

public class Runner {
	public static void main(String[] args) {
		AirPOO app = new AirPOO();
		app.cadastraPontosInteresse("Parque Ibirapuera", new Position(20, -30));
		app.cadastraPontosInteresse("Catedral Metropolitana", new Position(5, 40));
		app.cadastraResidencia("AP14", new Position(10, 10), 150.0, "AP14", 3, 2, 1, true);
		app.cadastraResidencia("AP99", new Position(-15, 7), 180.0, "AP99", 2, 2, 9);
		app.cadastraResidencia("DECOURT01", new Position(37, 81), 450, "DECOURT01", 5, 4, true);
		app.cadastraResidencia("GASTEI01RIM", new Position(56, 21), 2000.0, "GASTEI01RIM", 1200.0);
		app.cadastraRede("RED1", "RED1", 20.0);
		app.cadastraExperience("RODIZIOPIZZA", new Position(25, 56), "RODIZIOPIZZA", 10, 59.0, 39.0);
		app.show();
		app.cadastraReserva("AP14", 4, 2, 3);
		app.cadastraReserva("RODIZIOPIZZA", 4, 2, 1);
		app.cadastraReserva("DECOURT01", 2, 0, 10);
		app.cadastraReserva("GASTEI01RIM", 5, 0, 5);
		app.cadastraReserva("RED1", 5, 0, 10);
		app.showReservas();
		app.remove("RED1");
		app.show();
	}
}
