package pacote;

import java.util.ArrayList;

public class Predio {
	String nome;
	ArrayList<Sala> salas;

	
	public Predio(String nome) {
		this.nome = nome;
	}

	void addSala(String nome) {
		salas.add(new Sala(nome));
	}
	
	void addSala(String nome, int capacidade) {
		salas.add(new Sala(nome,capacidade));
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
			if(s.nome == nome)
				return i;
		}
		return -1;
	}

	public void setNome(String newNome) {
		this.nome = newNome;
	}
}
