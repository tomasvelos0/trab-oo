package engine;

public class Aluno extends Matriculado {
	String curso;
	
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.categoria = "Aluno";
	}


}