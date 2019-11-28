package pacote;

public class Aluno extends Matriculado {
	String curso;
	
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.categoria = "Aluno";
	}

	public boolean professor() {
		return false;
	}
	
	//Get e Set
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}


}
