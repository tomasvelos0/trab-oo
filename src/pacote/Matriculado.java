package pacote;

public class Matriculado {
	String matricula;
	String nome;
	String email;
	String datainicio;
	String categoria;
	int idade;

	//Get e Set

	public boolean isProfessor(){
		return false;
	}
	
	public void setNome(String newNome) {
		this.nome = newNome;
	}

	public void setMatricula(String newMatricula) {
		this.matricula = newMatricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}
	
}
