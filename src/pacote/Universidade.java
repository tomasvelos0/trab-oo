package pacote;

import java.util.ArrayList;

public class Universidade {
	String nome;
	ArrayList<Campus> campus = new ArrayList<Campus>();
	ArrayList<Matriculado> matriculado = new ArrayList<Matriculado>();
	
	void addCampus(String nome) {
		campus.add(new Campus(nome));
	}
	
	public Universidade(String nome) {
		super();
		this.nome = nome;
	}

	void removeCampus(int id) {
		campus.remove(id);
	}	
	
	void editCampus(int id, String newNome) {
		Campus c = campus.get(id);
		c.setNome(newNome);
	}
	
	int getIDCampusStr(String nome) {
		for(int i = 0; i<campus.size();i++) {
			Campus c = campus.get(i);
			if(c.nome.equals(nome))
				return i;
		}
		return -1;
	}
	
	void addProfessor(String nome, String matricula) {
		matriculado.add(new Professor(nome,matricula));
		// criar um exceção para no caso de colocar matricula repetida;
	}
	
	void addAluno(String nome, String matricula) {
		matriculado.add(new Aluno(nome, matricula));
		
	}
	
	void removeMatriculado(int id) {
		matriculado.remove(id);
	}

	// editar nome do matriculado
	void editMatriculado(int id, String newNome, String newMatricula) {
		Matriculado m = matriculado.get(id);
		m.setNome(newNome);
		m.setMatricula(newMatricula);
	}
	
	int getIDMatriculadoStr(String matricula) {
		// melhor por como matricula, pois pde ter dois nomes igual
		for(int i = 0; i<matriculado.size();i++) {
			Matriculado m = matriculado.get(i);
			if(m.matricula.equals(matricula))
				return i;
		}
		return -1;
		// se alguem conseguir mexer tem dois metodos que podem ficar esteticamente mais bonito (indexOf ou o contain)
	}
	
	void infUniver() {
		System.out.println(this.nome + ":");
		for(int i = 0; i<matriculado.size(); i++) {
			if(matriculado.get(i).isProfessor()) 
				System.out.println("	Matriculados["+ i +"]: " + matriculado.get(i).nome + "|Professor|" + matriculado.get(i).matricula);
			else
				System.out.println("	Matriculados["+ i +"]: " + matriculado.get(i).nome + "|Aluno|" + matriculado.get(i).matricula);
		}
		for(int i = 0; i<campus.size(); i++) {
			System.out.println("	Campus["+ i +"]: " + campus.get(i).nome);
			campus.get(i).infCampus();
		}
	}
}