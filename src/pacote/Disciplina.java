package pacote;
import java.util.ArrayList;

public class Disciplina {
	String nome;
	Campus campus;
	int credito;
	public String tipo_aula; 
	ArrayList<Turma> turmas = new ArrayList<Turma>();
	
	public Disciplina(String nome,int credito, Campus campus, String tipo_aula) {
		this.nome = nome;
		this.credito = credito;
		this.campus = campus;
		this.tipo_aula = tipo_aula;
	}

	void addTurma(String nome, int qtdAlunos, int dia, int hora) {
		turmas.add(new Turma(nome, this, qtdAlunos, dia, hora));
	}
	
	void addTurma(String nome, int qtdAlunos, int dia, int hora, int dia2, int hora2, int dia3, int hora3) {
		turmas.add(new Turma(nome, this, qtdAlunos, dia, hora, dia2, hora2, dia3, hora3));
	}
	
	void addTurma(String nome, int qtdAlunos, int dia, int hora, int dia2, int hora2) {
		turmas.add(new Turma(nome, this, qtdAlunos, dia, hora, dia2, hora2));
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
	
	void editTurma(int id, String newNome, int newQtdAlunos) {
		Turma t = turmas.get(id);
		t.setNome(newNome);
		t.setQtdAlunos(newQtdAlunos);
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
			System.out.println("			Turmas["+ i +"]: " + turmas.get(i).nome+" | qtdAlunos:"+turmas.get(i).qtdAlunos);
			//turmas.get(i).infOcup();
		}
	}
	
}