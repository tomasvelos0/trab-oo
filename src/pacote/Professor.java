package pacote;

public class Professor extends Matriculado {
	String departamento;

	public Professor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.categoria = "Professor";
	}

	public boolean professor() {
		return true;
	}

	public boolean isProfessor(){
		return true;
	}
	
	//Get e Set
	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	
}
