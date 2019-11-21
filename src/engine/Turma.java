package engine;
import java.util.ArrayList;


public class Turma {
	String nome;
	int qtdAlunos;
	int horario;
	int dia;
	ArrayList<Ocupacao> ocupacao;
	
	public Turma(String nome) {
		this.nome = nome;
	}

	void deallocate(Sala sala) {
		
	}

	public void setNome(String newNome) {
		this.nome = newNome;		
	}

	public void setQtdAlunos(int newQtdAlunos) {
		this.qtdAlunos = newQtdAlunos;
	}

	public void setHorario(int newHorario) {
		this.horario = newHorario;
	}

	public void setDia(int newDia) {
		this.dia = newDia;
	}
}