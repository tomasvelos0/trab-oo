package pacote;

import java.util.ArrayList;
import java.util.Scanner;
import exception.*;

public class Predio {
	String nome;
	ArrayList<Sala> salas = new ArrayList<Sala>();

	
	public Predio(String nome) {
		this.nome = nome;
	}

	void addSala(String nome) {
		salas.add(new Sala(nome));
	}
	
	void addSala(String nome, int capacidade) {
		salas.add(new Sala(nome,capacidade));
	}
	
	void addSala(String nome, int capacidade, String tipo_aula) {
		salas.add(new Sala(nome, capacidade, tipo_aula));
		
	}
	
	void cadastrarSala() {
		boolean dados_completos = false;
		String nome = ""; 
		String tipo_aula = "";
		int capacidade = 0;
		
		while(dados_completos == false) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Para cadastrar uma nova sala informe:");
				
				System.out.println("1 - O nome:");
				nome = input.nextLine();
				
				System.out.println("2 - A capacidade:");
				capacidade = input.nextInt();
				input.nextLine();
				System.out.println("3 - O tipo de aula:");
				tipo_aula = input.nextLine();
				
				if (tipo_aula.length() == 0) {
					throw new TipoDeAulaNaoAtribuidoException();
				} else {
					dados_completos = true;
					break;
				}
				
			} catch (TipoDeAulaNaoAtribuidoException e) {
				System.out.println(e.getInfo());
			}
		}
		if(dados_completos) {
			this.addSala(nome, capacidade, tipo_aula);
			System.out.println("Sala cadastrada com sucesso!"); 
		}
	}

	void removeSala(int id) {
		salas.remove(id);
	}
	
	void editSala(int id, String newNome, int newCapacidade) {
		Sala s = salas.get(id);
		s.setNome(newNome);
		s.setNewCapacidade(newCapacidade);
	}
	
	int getIDSalaStr(String nome) {
		for(int i = 0; i<salas.size();i++) {
			Sala s = salas.get(i);
			if(s.nome.equals(nome))
				return i;
		}
		return -1;
	}

	public void setNome(String newNome) {
		this.nome = newNome;
	}
	
	void infPredio() {
		for(int i = 0; i<salas.size(); i++) {
			System.out.println("			Salas["+ i +"]: " + salas.get(i).nome);
			
		}
	}
	
}
