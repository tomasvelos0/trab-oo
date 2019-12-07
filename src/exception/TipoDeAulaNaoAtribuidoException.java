package exception;

public class TipoDeAulaNaoAtribuidoException extends Exception {
	//info = mensagem com informações sobre a exceção
	private String info = "Tipo de aula não atribuido. A sala não possui nenhum "
			+ "tipo de aula.";
	
	public TipoDeAulaNaoAtribuidoException() {
		super();
	}
	
	public TipoDeAulaNaoAtribuidoException(String info) {
		super(info);
	}
	
	//Get
	public String getInfo() {
		return this.info;
	}
}
