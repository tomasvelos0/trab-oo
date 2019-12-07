package exception;

public class DisciplinaNaoInformadaException extends Exception {
	
	//info = mensagem com informações sobre a exceção
	private String info = "Disciplina não informada. Para cadastrar a turma, "
			+ "informe a disciplina.";
	
	public DisciplinaNaoInformadaException() {
		super();
	}
	
	public DisciplinaNaoInformadaException(String info) {
		super(info);
	}

	//Get
	public String getInfo() {
		return info;
	}
	
}
