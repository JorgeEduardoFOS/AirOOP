package com.unicamp.mc322.Lab07;
import java.util.ArrayList;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class AirPOO {
	private DecimalFormat df0 = new DecimalFormat(".##");
	private ArrayList<Apartamento> alugaveisAp = new ArrayList<Apartamento>();
	private ArrayList<Casa> alugaveisCasa = new ArrayList<Casa>();
	private ArrayList<Mansao> alugaveisMansao = new ArrayList<Mansao>();
	private ArrayList<Experience> experiences = new ArrayList<Experience>();
	private ArrayList<PontosInteresse> pontosInteresse = new ArrayList<PontosInteresse>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Rede> redes = new ArrayList<Rede>();
	
	public AirPOO() {
		df0.setRoundingMode(RoundingMode.UP);
	}
	public void cadastraReserva(String code, int totalPessoas, int pessoasMenores, int dias) {
		if (searchCodes(code) == null)
			System.out.println("Código inválido, nada a ser feito.");
		else
			reservas.add(new Reserva(code, totalPessoas, pessoasMenores, dias));
	}
	public void cadastraRede(String name, String code, double price) {
		if (searchCodes(code) != null)
			System.out.println("Código inválido, nada a ser feito.");
		else
			redes.add(new Rede(name, code, price));
	}
	public void cadastraResidencia(String name, Position position, double diaria, String code, int quartos, int banheiros, int andar) {
		if (searchCodes(code) != null)
			System.out.println("Esse código já foi utilizado anteriormente. Nada a ser feito.");
		else
			alugaveisAp.add(new Apartamento(name, position, diaria, code, quartos, banheiros, andar));
	}
	public void cadastraResidencia(String name, Position position, double diaria, String code, int quartos, int banheiros, int andar, boolean sacada) {
		if (searchCodes(code) != null)
			System.out.println("Esse código já foi utilizado anteriormente. Nada a ser feito.");
		else
			alugaveisAp.add(new Apartamento(name, position, diaria, code, quartos, banheiros, andar, sacada));	
	}
	public void cadastraResidencia(String name, Position position, double diaria, String code, int quartos, int banheiros) {
		if (searchCodes(code) != null)
			System.out.println("Esse código já foi utilizado anteriormente. Nada a ser feito.");
		else
			alugaveisCasa.add(new Casa(name, position, diaria, code, quartos, banheiros));	
	}
	public void cadastraResidencia(String name, Position position, double diaria, String code, int quartos, int banheiros, boolean piscina) {
		if (searchCodes(code) != null)
			System.out.println("Esse código já foi utilizado anteriormente. Nada a ser feito.");
		else
			alugaveisCasa.add(new Casa(name, position, diaria, code, quartos, banheiros, piscina));
	}
	public void cadastraResidencia(String name, Position position, double diaria, String code, double area) {
		if (searchCodes(code) != null)
			System.out.println("Esse código já foi utilizado anteriormente. Nada a ser feito.");
		else
			alugaveisMansao.add(new Mansao(name, position, diaria, code, area));
	}
	public void cadastraExperience(String name, Position position, String code, int maxParticipantes, double priceBase, double priceMenor) {
		if (searchCodes(code) != null)
			System.out.println("Esse código já foi utilizado anteriormente. Nada a ser feito.");
		else
			experiences.add(new Experience(name, position, code, maxParticipantes, priceBase, priceMenor));
	}
	public void cadastraPontosInteresse(String name, Position position) {
		pontosInteresse.add(new PontosInteresse(name, position));
	}
	public void remove(String code) {
		Object temp;
		if((temp = searchCodeAp(code)) == null) {
			if((temp = searchCodeCasa(code)) == null) {
				if((temp = searchCodeMansao(code)) == null) {
					if((temp = searchCodeExperience(code)) == null) {
						if((temp = searchCodeRede(code)) == null)
							System.out.println("Código não encontrado.");
						else
							redes.remove(temp);
					}
					else
						experiences.remove(temp);
				}
				else
					alugaveisMansao.remove(temp);
			}
			else
				alugaveisCasa.remove(temp);
		}		
		else if((temp = searchCodeCasa(code)) == null)
			alugaveisAp.remove(temp);
	}
	public Apartamento searchCodeAp(String code) {
		for(Apartamento apartamento: alugaveisAp)
			if(apartamento.getCode().compareTo(code) == 0)
				return apartamento;
		return null;
	}
	public Casa searchCodeCasa(String code) {
		for(Casa casa: alugaveisCasa)
			if(casa.getCode().compareTo(code) == 0)
				return casa;
		return null;
	}
	public Mansao searchCodeMansao(String code) {
		for(Mansao mansao: alugaveisMansao)
			if(mansao.getCode().compareTo(code) == 0)
				return mansao;
		return null;
	}
	public Experience searchCodeExperience(String code) {
		for(Experience experience: experiences)
		if(experience.getCode().compareTo(code) == 0)
			return experience;
	return null;
	}
	public Rede searchCodeRede(String code) {
		for(Rede rd: redes)
		if(rd.getCode().compareTo(code) == 0)
			return rd;
	return null;
	}
	public Object searchCodes(String code) {
		Object obj;
		if((obj = searchCodeAp(code)) == null) {
			if((obj= searchCodeCasa(code)) == null) {
				if((obj= searchCodeMansao(code)) == null) {
					if((obj = searchCodeExperience(code)) == null) {
						if((obj = searchCodeRede(code)) == null)
							return null;
						else
							return obj;
					}
					else
						return obj;
				}
				else
					return obj;
			}
			else
				return obj;
		}
		else
			return obj;
	}
	public void show() {
		System.out.println("////////////////\n---Cadastrados---\n////////////////");
		showApartamento();
		showCasa();
		showMansao();
		showExperience();
		showRede();
	}
	public void showApartamento() {
		System.out.println("------------------------\n---Apartamentos---\n----------------------");
		for(Apartamento ap: alugaveisAp) {
			System.out.println("---------------\nApartamento: " + ap.getName());
			System.out.println("O número de banheiros é: " + ap.getBanheiros());
			System.out.println("O número de quartos é :" + ap.getQuartos());
			System.out.println("A diária base é de: R$" + ap.getDiariaBase());
			if(ap.getSacada())
				System.out.println("Tem sacada.");
			for(PontosInteresse pi: pontosInteresse) {
				System.out.println("Ponto: " + pi.getName());
				System.out.println("Distância: " + getDistances(ap, pi));
			}
		}
	}
	public void showCasa() {
		System.out.println("------------------------\n---Casas---\n----------------------");
		for(Casa cs: alugaveisCasa) {
			System.out.println("---------------\nCasa: " + cs.getName());
			System.out.println("O número de banheiros é: " + cs.getBanheiros());
			System.out.println("O número de quartos é :" + cs.getQuartos());
			System.out.println("A diária base é de: R$" + cs.getDiariaBase());
			if(cs.getPiscina())
				System.out.println("Tem piscina.");
			for(PontosInteresse pi: pontosInteresse) {
				System.out.println("Ponto: " + pi.getName());
				System.out.println("Distância: " + getDistances(cs, pi));
			}
		}
	}
	public void showMansao() {
		System.out.println("------------------------\n---Mansões---\n----------------------");
		for(Mansao mn: alugaveisMansao) {
			System.out.println("---------------\nMansão: " + mn.getName());
			System.out.println("A área é de : " + mn.getArea() + "m^2");
			System.out.println("A diária base é de: R$" + mn.getPrice());
			for(PontosInteresse pi: pontosInteresse) {
				System.out.println("Ponto: " + pi.getName());
				System.out.println("Distância: " + getDistances(mn, pi));
			}
		}
	}
	public void showExperience() {
		System.out.println("------------------------\n---Experiências---\n----------------------");
		for(Experience xp: experiences) {
			System.out.println("---------------\nExperiência: " + xp.getName());
			System.out.println("O preço base por pessoa é de: R$" + xp.getPriceBase());
			System.out.println("O preço descontado para menores de idade é de: R$" + xp.getPriceMenor());
			for(PontosInteresse pi: pontosInteresse) {
				System.out.println("Ponto: " + pi.getName());
				System.out.println("Distância: " + getDistances(xp, pi));
			}
		}
	}
	public void showRede() {
		System.out.println("------------------------\n---Redes---\n----------------------");
		for(Rede rd: redes) {
			System.out.println("---------------\nRede: " + rd.getName());
			System.out.println("O preço base é de: R$" + rd.getPriceBase());
		}
	}
	public void showReservas() {
		System.out.println("////////////////\n---Reservas---\n////////////////");
		for(Reserva rs: reservas) {
			Apartamento ap;
			if((ap = searchCodeAp(rs.getCode())) == null) {
				Casa casa;
				if((casa = searchCodeCasa(rs.getCode())) == null) {
					Mansao mansao;
					if((mansao = searchCodeMansao(rs.getCode())) == null) {
						Experience xp;
						if((xp = searchCodeExperience(rs.getCode())) == null) {
							Rede rd;
							if((rd = searchCodeRede(rs.getCode())) == null)
								System.out.println("Reserva não encontrada.");
							else {
								System.out.println("-------------------\nReserva de: " + rd.getName());
								System.out.println("Custo: R$" + rd.getPrice(rs.getPessoas(), rs.getDias()));
							}
						}
						else {
							System.out.println("-------------------\nReserva de: " + xp.getName());
							System.out.println("Custo: R$" + xp.getPrice(rs.getPessoas(), rs.getPessoasMenores()));
						}
					}
					else {
						System.out.println("-------------------\nReserva de: " + mansao.getName());
						System.out.println("Custo: R$" + mansao.getPrice(rs.getDias(), rs.getPessoas()));
					}
				}
				else{
					System.out.println("-------------------\nReserva de: " + casa.getName());
					System.out.println("Custo: R$" + casa.getPrice(rs.getDias()));
				}
			}
			else{
				System.out.println("-------------------\nReserva de: " + ap.getName());
				System.out.println("Custo: R$" + ap.getPrice(rs.getDias()));
			}
		}
	}
	public String getDistances(Local local1, Local local2) {
		return df0.format(Math.sqrt(Math.pow(local1.getPosition().getX() - local2.getPosition().getX(), 2) + Math.pow(local1.getPosition().getY() - local2.getPosition().getY(), 2)));
	}
}