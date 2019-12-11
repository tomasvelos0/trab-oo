package pacote;
import java.util.ArrayList;
import java.util.Vector;

public class Turma {
	String nome;
	int qtdAlunos;
	ArrayList<Horario> horario = new ArrayList<Horario>();
	ArrayList<Ocupacao> ocupacao = new ArrayList<Ocupacao>();
	Matriculado professor;
	Disciplina disciplina;
	public boolean isAllocated = false;
	
	
	public Turma(String nome, Disciplina disciplina, int qtdAlunos, int horario, int dia) {
		this.nome = nome;
		this.disciplina = disciplina;
		this.horario.add(new Horario(dia,horario));
		this.qtdAlunos = qtdAlunos;
	}
	
	public Turma(String nome, Disciplina disciplina, int qtdAlunos, int horario, int dia, int horario2, int dia2, int horario3, int dia3) {
		this.nome = nome;
		this.disciplina = disciplina;
		this.horario.add(new Horario(dia,horario));
		this.horario.add(new Horario(dia2,horario2));
		this.horario.add(new Horario(dia3,horario3));
		this.qtdAlunos = qtdAlunos;
	}
	
	public Turma(String nome, Disciplina disciplina, int qtdAlunos, int horario, int dia, int horario2, int dia2) {
		this.nome = nome;
		this.disciplina = disciplina;
		this.horario.add(new Horario(dia,horario));
		this.horario.add(new Horario(dia2,horario2));
		this.qtdAlunos = qtdAlunos;
	}
	
	public Turma(String nome, int qtdAlunos, int horario, int dia, Matriculado professor, Disciplina disciplina) {
		this.nome = nome;
		this.qtdAlunos = qtdAlunos;
		this.horario.add(new Horario(dia,horario));
		this.professor = professor;
	}
	
	public Turma(String nome, int qtdAlunos, int horario, int dia, int horario2, int dia2, int horario3, int dia3, Matriculado professor, Disciplina disciplina) {
		this.nome = nome;
		this.qtdAlunos = qtdAlunos;
		this.horario.add(new Horario(dia,horario));
		this.horario.add(new Horario(dia2,horario2));
		this.horario.add(new Horario(dia3,horario3));
		this.professor = professor;
	}

	public Turma(String nome, int qtdAlunos, int horario, int dia, int horario2, int dia2, Matriculado professor, Disciplina disciplina) {
		this.nome = nome;
		this.qtdAlunos = qtdAlunos;
		this.horario.add(new Horario(dia,horario));
		this.horario.add(new Horario(dia2,horario2));
		this.professor = professor;
	}
	
	void deallocate() {
		Vector<Integer> ids = new Vector<>();
		//Desvinculando as ocupacoes nas salas 
		for(Ocupacao o : this.ocupacao) {
			o.sala.deallocateTurma(this);
			o.sala = null;
			o.turma = null;
			ids.add(this.ocupacao.indexOf(o));
		}
		for(int i : ids) {
			ocupacao.remove(i-ids.indexOf(i));
		}
		this.isAllocated = false;
	}
	
	void deallocateAll() {
		//Desvinculando as ocupacoes de todas as salas
		for(int i=0; i<this.ocupacao.size(); i++) {
			this.ocupacao.remove(i);
			ocupacao.get(i).setSala(null);
		}
		
	}

	public void setNome(String newNome) {
		this.nome = newNome;		
	}

	public void setQtdAlunos(int newQtdAlunos) {
		this.qtdAlunos = newQtdAlunos;
	}
	
	public void infOcup() {
		for(int i = 0; i<ocupacao.size(); i++) {
			System.out.println("			Ocupadas por ["+ i +"]: " + ocupacao.get(i).getDia() + " e na hora " + ocupacao.get(i).getHora());
		}
	}

	public void infTurma() {
		System.out.println("|matéria:" + disciplina.nome + "|Turma:" + this.nome + "|tipo: " + this.disciplina.tipo_aula);
		
	}

}