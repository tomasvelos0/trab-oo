package pacote;

public class Matriculado {
	String matricula;
	String nome;
	String email;
	String datainicio;
	int idade;


	boolean professor() {
		return false;
	}


	public void setNome(String newNome) {
		this.nome = newNome;
	}

	public void setMatricula(String newMatricula) {
		this.matricula = newMatricula;
	}
}
