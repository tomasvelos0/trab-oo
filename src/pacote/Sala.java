package pacote;
import java.util.ArrayList;

public class Sala {
	String nome;
	int capacidade;
	ArrayList<Ocupacao> ocupacao = new ArrayList<Ocupacao>();
	//Tipo de aula que ocorrera na sala, caso nao informado lança exceção
	private String tipo_aula; 
	
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
	
	public String getTipo_aula() {
		return tipo_aula;
	}

	public void setTipo_aula(String tipo_aula) {
		this.tipo_aula = tipo_aula;
	}
	
}
