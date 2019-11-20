package pacote;

public class Professor extends Matriculado {
	String departamento;

	public Professor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	boolean professor() {
		return true;
	}
}
