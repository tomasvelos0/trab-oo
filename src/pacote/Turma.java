package pacote;
import java.util.ArrayList;


public class Turma {
	String nome;
	int qtdAlunos;
	int horario;
	int dia;
	ArrayList<Ocupacao> ocupacao = new ArrayList<Ocupacao>();
	String professor;
	String disciplina;
	
	
	public Turma(String nome) {
		this.nome = nome;
	}
	
	public Turma(String nome, int qtdAlunos, int horario, int dia, String professor, String disciplina) {
		this.nome = nome;
		this.qtdAlunos = qtdAlunos;
		this.horario = horario;
		this.dia = dia;
		this.professor = professor;
		this.disciplina = disciplina;
	}

	void deallocate(Sala sala) {
		//Desvinculando as ocupacoes nas salas 
		for(Ocupacao o : sala.ocupacao) {
			if(o.getTurma() == this) {
				sala.ocupacao.remove(o);
			}
		}
		//removendo as salas das ocupacoes
		for(Ocupacao o : this.ocupacao) {
			if(o.getSala() == sala) {
				o.setSala(null);
			}
		}
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