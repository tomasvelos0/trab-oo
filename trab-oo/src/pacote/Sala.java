package pacote;
import java.util.ArrayList;
import java.util.Vector;

public class Sala implements Comparable<Sala> {
	String nome;
	int capacidade;
	Predio predio;
	ArrayList<Ocupacao> ocupacao = new ArrayList<Ocupacao>();
	//Tipo de aula que ocorrera na sala, caso nao informado lança exceção
	private String tipo_aula; 
	
	public Sala(String nome) {
		this.nome = nome;
	}
	
	public Sala(String nome, int capacidade, String tipo_aula) {
		this.nome = nome;
		this.capacidade = capacidade;
		this.tipo_aula = tipo_aula;
	}
	
	public Sala(String nome, int capacidade, String tipo_aula, Predio predio) {
		this.nome = nome;
		this.capacidade = capacidade;
		this.tipo_aula = tipo_aula;
		this.predio = predio;
	}
	
	//Caso o horario esteja disponivel na sala, retorna true.
	boolean checkHorario(Turma turma){
		for(Horario h : turma.horario) {
			for(Ocupacao o : ocupacao) {
				if((o.dia==h.dia)&&(o.hora==h.horario)) {
					return false;
				}
			}
		}
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

	public void infSala() {
		for(int i = 0; i<ocupacao.size(); i++) {
			System.out.print("				Ocupacao["+ i +"]: dia:" + ocupacao.get(i).dia + "|horario:" + ocupacao.get(i).hora);
			ocupacao.get(i).turma.infTurma();
		}
	}

	@Override     
	public int compareTo(Sala sala) {          
		return (this.getCapacidade() < sala.getCapacidade() ? -1 : 
			(this.getCapacidade() == sala.getCapacidade() ? 0 : 1));     
	} 
	
	public int getCapacidade() {
		return capacidade;
	}
	
	public void deallocateTurma(Turma turma) {
		Vector<Integer> ids = new Vector<>();
		for(Ocupacao o : ocupacao) {
			if(o.turma == turma) {
				ids.add(this.ocupacao.indexOf(o));
			}
		}
		for(int i : ids) {
			ocupacao.remove(i-ids.indexOf(i));
		}
	}
}