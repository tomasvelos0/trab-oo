package pacote;
import java.util.ArrayList;
import java.util.Scanner;
import exception.*;

public class Disciplina {
	String nome;
	int credito;
	ArrayList<Turma> turmas = new ArrayList<Turma>();
	
	public Disciplina(String nome,int credito) {
		this.nome = nome;
		this.credito = credito;
	}

	void addTurma(String nome) {
		turmas.add(new Turma(nome));
	}
	
	void addTurma(String nome, int qtdAlunos, int horario, int dia, String professor, String disciplina) {
		turmas.add(new Turma(nome, qtdAlunos, horario, dia, professor, disciplina));
	}
	
	void cadastrarTurma() {
		boolean dados_completos = false;
		String nome = "";
		int qtdAlunos = 0;
		int horario = 0;
		int dia = 0;
		String professor = "";
		String disciplina = "";
		
		while(dados_completos == false) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Para cadastrar uma nova turma, informe:");
				
				System.out.println("1 - O nome:");
				nome = input.next();
				
				System.out.println("2 - A quantidade de alunos:");
				qtdAlunos = input.nextInt();
				
				System.out.println("3 - O horario:");
				horario = input.nextInt();
				
				System.out.println("4 - O dia:");
				dia = input.nextInt();
				input.nextLine();
				
				System.out.println("5 - O professor:");
				professor = input.nextLine();
				
				System.out.println("6 - A disciplina:");
				disciplina = input.nextLine();
				
				if (professor.length() == 0) {
					throw new ProfessorNaoAtribuidoException();
				
				} else if(disciplina.length() == 0) {
					throw new DisciplinaNaoInformadaException();
				
				} else {
					dados_completos = true;
					break;
				}
			} catch (ProfessorNaoAtribuidoException e) {
				System.out.println(e.getInfo());
			
			} catch (DisciplinaNaoInformadaException e) {
				System.out.println(e.getInfo());
			}
		}
		if(dados_completos) {
			turmas.add(new Turma(nome, qtdAlunos, horario, dia, professor, disciplina));
			System.out.println("Turma cadastrada com sucesso!");
		}
	}
	
	void removeTurma(int id) {
		turmas.remove(id);
	}

	void cleanTurma() {
		for(int i = 0; i < turmas.size(); i++) {
			turmas.remove(i);
		}
	}
	
	void editTurma(int id, String newNome, int newQtdAlunos, int newHorario, int newDia) {
		Turma t = turmas.get(id);
		t.setNome(newNome);
		t.setQtdAlunos(newQtdAlunos);
		t.setHorario(newHorario);
		t.setDia(newDia);
	}
	
	int getIDTurmaStr(String nome) {
		for(int i = 0; i<turmas.size();i++) {
			Turma t = turmas.get(i);
			if(t.nome.equals(nome))
				return i;
		}
		return -1;
	}

	public void setNome(String newNome) {
		this.nome = newNome;		
	}

	public void setCredito(int newCredito) {
		this.credito = newCredito;		
	}
	
	void infDis() {
		for(int i = 0; i<turmas.size(); i++) {
			System.out.println("			Salas["+ i +"]: " + turmas.get(i).nome);
			
		}
	}
	
}
