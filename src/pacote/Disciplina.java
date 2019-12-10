package pacote;
import java.util.ArrayList;
import java.util.Scanner;
import exception.*;

public class Disciplina {
	String nome;
	Campus campus;
	int credito;
	ArrayList<Turma> turmas = new ArrayList<Turma>();
	
	public Disciplina(String nome,int credito, Campus campus) {
		this.nome = nome;
		this.credito = credito;
		this.campus = campus;
	}

	void addTurma(String nome) {
		turmas.add(new Turma(nome));
	}
	
	void addTurma(String nome, int qtdAlunos, int horario, int dia, Matriculado professor, Disciplina disciplina) {
		turmas.add(new Turma(nome, qtdAlunos, horario, dia, professor, disciplina));
	}
	
	
	
	void removeTurma(int id) {
		turmas.remove(id);
	}

	void cleanTurma() {
		for(int i = 0; i < turmas.size(); i++) {
			turmas.remove(i);
		}
	}
	
	void editTurma(int id, String newNome, int newQtdAlunos, int newHorario, int newDia) {
		Turma t = turmas.get(id);
		t.setNome(newNome);
		t.setQtdAlunos(newQtdAlunos);
		t.setHorario(newHorario);
		t.setDia(newDia);
	}
	
	int getIDTurmaStr(String nome) {
		for(int i = 0; i<turmas.size();i++) {
			Turma t = turmas.get(i);
			if(t.nome.equals(nome))
				return i;
		}
		return -1;
	}

	public void setNome(String newNome) {
		this.nome = newNome;		
	}

	public void setCredito(int newCredito) {
		this.credito = newCredito;		
	}
	
	void infDis() {
		for(int i = 0; i<turmas.size(); i++) {
			System.out.println("			Salas["+ i +"]: " + turmas.get(i).nome);
			//turmas.get(i).infOcup();
		}
	}
	
}