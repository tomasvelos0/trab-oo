package exception;

public class ProfessorNaoAtribuidoException extends Exception {
	//info = mensagem com informações sobre a exceção
	private String info = "Professor não atribuido. Para cadastrar uma turma, "
			+ "informe pelo menos um professor.";
	
	public ProfessorNaoAtribuidoException () {
		super();
	}
	
	public ProfessorNaoAtribuidoException (String info) {
		super(info);
	}
	
	//Get
	public String getInfo() {
		return this.info;
	}
}
