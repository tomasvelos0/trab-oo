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
			if(p.nome.equals(nome))
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
			if(d.nome.equals(nome))
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
	/* - Eric: fiz assim mas não tenho certeza se é esse o funcionamento 
	 * desse método, se alguém puder alterar caso nao seja */
	void allocateTurmas() {
		for (Disciplina d : disciplinas) {
			for (Turma t : d.turmas) {
				this.allocateTurma(t);
			}
		}
	}
	
	/*Percorre todas as salas em busca de horario e capacidade compativeis com
	 * a turma. Entao aloca uma ocupacao conectando sala e turma.*/
	void allocateTurma(Turma turma) {
		Ocupacao ocupacao;
		boolean salaEncontrada = false;
		for (Predio p : predios) {
			for(Sala s : p.salas) {
				if (s.capacidade >= turma.qtdAlunos) {
					if(s.checkHorario(turma)) {
						ocupacao = new Ocupacao(turma.dia, turma.horario, s, turma);
						s.ocupacao.add(ocupacao);
						turma.ocupacao.add(ocupacao);
						salaEncontrada = true;
						break;
					}
				}
			}
			if(salaEncontrada) {
				break;
			}
		}
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
	
	void infCampus() {
		for(int i = 0; i<predios.size(); i++) {
			System.out.println("		Prédio["+ i +"]: " + predios.get(i).nome);
			predios.get(i).infPredio();
		}
		for(int i = 0; i<disciplinas.size(); i++) {
			System.out.println("		Disciplinas["+ i +"]: " + disciplinas.get(i).nome + " | créditos: " + disciplinas.get(i).credito);
			disciplinas.get(i).infDis();
		}
	}

}
