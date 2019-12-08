package pacote;
//import java.util.ArrayList;

public class Ocupacao {
	private int dia;
	private int hora;
	private Sala sala;
	private Turma turma;
	
	public Ocupacao(int dia, int hora) {
		this.dia = dia;
		this.hora = hora;
	}
	
	public Ocupacao(int dia, int hora, Sala sala, Turma turma) {
		this.dia = dia;
		this.hora = hora;
		this.sala = sala;
		this.turma = turma;
	}
	
	public void destroiSala() {
		this.sala = null;
	}
	public void destroiTurma() {
		this.turma = null;
	}
	
	//Get e Set
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
}
