package pacote;
import java.util.ArrayList;

public class Sala {
	String nome;
	int capacidade;
	ArrayList<Ocupacao> ocupacao;
	
	public Sala(String nome) {
		this.nome = nome;
	}
	
	public Sala(String nome, int capacidade) {
		this.nome = nome;
		this.capacidade = capacidade;
	}

	boolean checkHorario(Turma turma){
		return true;
	}

	public void setNome(String newNome) {
		this.nome = newNome;
	}

	public void setNewCapacidade(int newCapacidade) {
		this.capacidade = newCapacidade;
	}
	
}
