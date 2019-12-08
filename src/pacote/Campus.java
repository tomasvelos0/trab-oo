package pacote;

import java.util.ArrayList;

public class Campus {
	String nome;
	ArrayList<Predio> predios = new ArrayList<Predio>();
	ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Campus(String nome) {
		this.nome = nome;
	}

	void addPredio(String nome) {
		predios.add(new Predio(nome));
	}
	
	void removePredio(int id) {
		predios.remove(id);
	}
	
	void editPredio(int id, String newNome) {
		Predio p = predios.get(id);
		p.setNome(newNome);
	}
	
	int getIDPredioStr(String nome) {
		for(int i = 0; i<predios.size();i++) {
			Predio p = predios.get(i);
			if(p.nome == nome)
				return i;
		}
		return -1;
	}
	
	void addDisciplina(String nome, int credito) {
		disciplinas.add(new Disciplina(nome,credito));
	}
	
	void removeDisciplina(int id) {
		disciplinas.remove(id);
	}
	
	void editDisciplina(int id, String newNome, int newCredito) {
		Disciplina d = disciplinas.get(id);
		d.setNome(newNome);
		d.setCredito(newCredito);
	}
	
	int getIDDisciplinaStr(String nome) {
		for(int i = 0; i<disciplinas.size();i++) {
			Disciplina d = disciplinas.get(i);
			if(d.nome == nome)
				return i;
		}
		return -1;
	}
	
	// Apaga todas as Turmas (e suas Ocupações) de todas as Disciplinas do 
	//campus.
	void cleanTurmas() {
		//Desalocando as ocupações nas Salas
		for(Predio p : predios) {
			for(Sala s : p.salas) {
				s.ocupacao.clear();
			}
		}
		//Desalocando as ocupações em turmas, e removendo as turmas.
		for(Disciplina d : disciplinas) {
			for(Turma t : d.turmas) {
				t.ocupacao.clear();
			}
			d.turmas.clear();
		}
	}
	
	void cleanSalas() {
		/* Desalocando as referências para salas nas ocupações de todas 
		 * as turmas. */
		for (Disciplina d : disciplinas) {
			for (Turma t : d.turmas) {
				for (Ocupacao o : t.ocupacao) {
					o.destroiSala();
				}
			}
		}
		//Removendo todas as salas de todos os prédios
		for (Predio p : predios) {
			p.salas.clear();
		}
		
	}
	
	void allocateTurmas() {
		
	}
	
	void allocateTurma(Turma turma) {
		
	}

	public ArrayList<Predio> getPredios() {
		return predios;
	}

	public void setPredios(ArrayList<Predio> predios) {
		this.predios = predios;
	}

	public void setNome(String newNome) {
		this.nome = newNome;
	}
	

}
