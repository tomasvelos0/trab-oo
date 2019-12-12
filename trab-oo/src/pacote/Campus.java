package pacote;

import java.util.ArrayList;
import java.util.Collections;

import exception.DisciplinaNaoInformadaException;
import exception.ProfessorNaoAtribuidoException;

public class Campus {
	String nome;
	Universidade uni;
	ArrayList<Predio> predios = new ArrayList<Predio>();
	ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Campus(String nome, Universidade uni) {
		this.nome = nome;
		this.uni = uni;
	}

	void addPredio(String nome) {
		predios.add(new Predio(nome));
	}
	
	void cadastrarTurma(String nome, int qtdAlunos, int horario, int dia, String professor, String dis) throws ProfessorNaoAtribuidoException , DisciplinaNaoInformadaException {
		
		if (professor.length() == 0) {
			throw new ProfessorNaoAtribuidoException();
		
		} else if(dis.length() == 0) {
			throw new DisciplinaNaoInformadaException();
		
		} else {
			Matriculado prof;
			Disciplina disciplina;
			int index = this.uni.getIDMatriculadoStr(professor);
			if(index > -1) {
				prof = this.uni.matriculado.get(index);
				if(prof.isProfessor()) {
					index = this.getIDDisciplinaStr(dis);
					if (index > -1) {
						disciplina = this.disciplinas.get(index);
						disciplina.addTurma(nome, qtdAlunos, horario, dia);
						System.out.println("Turma cadastrada com sucesso!");

					} else {
						System.out.println("Disciplina não encontrada.");
					}
				} else {
					System.out.println("A matricula não corresponde a um professor.");
				}
			} else {
				System.out.println("Professor não encontrado.");
			}
			
		}
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
	
	void addDisciplina(String nome, int credito, String tipo_aula) {
		disciplinas.add(new Disciplina(nome,credito, this, tipo_aula));
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
	boolean allocateTurma(Turma turma) {
		if(turma.isAllocated)
			return false;
		ArrayList<Sala> salas = new ArrayList<Sala>();
		for(Predio p : predios) {
			for(Sala s : p.salas) {
				if(s.getTipo_aula().equals(turma.disciplina.tipo_aula)) {
					salas.add(s);
				}
			}
		}
		Collections.sort(salas);  //Sorteia as salas em ordem crescente e pega a primeira que der
		Ocupacao ocupacao;
		for(Sala s : salas) {
			if (s.capacidade >= turma.qtdAlunos) {
				if(s.checkHorario(turma)) {
					for(Horario h : turma.horario) {
						ocupacao = new Ocupacao(h.dia, h.horario, s, turma);
						s.ocupacao.add(ocupacao);
						turma.ocupacao.add(ocupacao);
						turma.isAllocated = true;
					}
					return true;
				}
			}
		}
		return false;
	}

	// criar metodo que aloca todas as turmas de uma vez
	void allocateTurmaAll() {
		for(Disciplina d : disciplinas) {
			for(Turma t : d.turmas) {
				this.allocateTurma(t);
			}
		}
		/*Ocupacao ocupacao;
		boolean salaEncontrada = false;
		for(int i=0; i<this.predios.size(); i++){
			ArrayList<Integer> dif = new ArrayList<Integer>();
			// fazer o array dif receber a diferença entre a capacidade da sala e a qtd de alunos
			for(int k =0; k< this.predios.get(i).salas.size(); k++) {
				for (int j = 0; j < this.disciplinas.size(); j++) {
					for (int n = 0; n < this.disciplinas.get(j).turmas.size(); n++) {
						dif.add(predios.get(i).salas.get(k).capacidade-this.disciplinas.get(j).turmas.get(n).qtdAlunos);
					}
				}
			}

			// criando um arraylist ordenado de dif
			ArrayList <Integer> difOrnd = new ArrayList<Integer>();
			for (int j = 0; j < dif.size(); j++) {
				difOrnd.add(dif.get(i));
			}
			Collections.sort(difOrnd);				
			//int idmin = dif.indexOf(Collections.min(dif));

			// verificar se as as ordenadas ( melhores escolhas) estao disponiveis
			for (int i1=0; i1 < this.predios.size(); i1++) {
				for (int j = 0; j < this.predios.get(i1).salas.size(); j++) {
					for (int k = 0; k < this.disciplinas.size(); k++) {
						for (int n = 0; n < this.disciplinas.get(k).turmas.size(); n++) {
							if(this.predios.get(i1).salas.get(dif.indexOf(difOrnd.get(j))).checkHorario(this.disciplinas.get(k).turmas.get(n))) {
								ocupacao = new Ocupacao(this.disciplinas.get(k).turmas.get(n).dia,this.disciplinas.get(k).turmas.get(n).horario,
										predios.get(i1).salas.get(i1), this.disciplinas.get(i1).turmas.get(i1));
								this.predios.get(i1).salas.get(j).ocupacao.add(ocupacao);
								salaEncontrada = true;
								break;

							}
						}

					}
				}
				if(salaEncontrada) {
					break;
				}
			}
		}*/
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

	public void dellocateall() {
		for(Disciplina d : disciplinas) {
			for(Turma t : d.turmas) {
				t.deallocate();
			}
		}
	}

}