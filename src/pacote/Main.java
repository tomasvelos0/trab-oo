package pacote;

import java.util.Scanner;
import exception.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Deseja popular a universidade automaticamente?: ");
		System.out.println("(1)Sim\n(2)Não");
		int r = in.nextInt();
		Universidade uni;
		Campus campus;
		Predio predio;
		Disciplina disciplina;
		Matriculado matriculado;
		Turma turma;
		Sala sala;

		int menu = 0;
		if (r==2) {
			System.out.println("Qual o nome da universidade? ");
			String s = in.next();
			uni = new Universidade(s);
			System.out.println(s + " criado com sucesso");
			System.out.println("Quantos campus a universidade possuirá? ");
			int c = in.nextInt();
			for(int i=0; i<c; i++) {
				System.out.println("Nome do campus: ");
				String ss = in.next();
				uni.addCampus(ss);
			}
		} else if(r==1) {
			System.out.println("Populando!\n");
			uni = new Universidade("UnB");
			uni.addCampus("FGA");
			uni.addProfessor("Lanna", "130000000");
			uni.addAluno("Vitor", "130000001");
			uni.addAluno("Natan", "130000002");
			uni.addAluno("Tomás", "130000003");
			uni.addAluno("Eric", "130000004");
			campus = uni.campus.get(uni.getIDCampusStr("FGA"));
			campus.addPredio("UED");
			predio = campus.predios.get(campus.getIDPredioStr("UED"));
			predio.addSala("Lab SS");
			predio.addSala("Mocap");
			predio.addSala("Lab NEI");
			predio.addSala("Lab Eletricidade");
			predio.addSala("Lab Materiais");
			predio.addSala("Lab Termo");
			predio.addSala("Lab LEI");
			predio.addSala("Lab Física");
			predio.addSala("Lab Química");
			campus.addPredio("UAC");
			predio = campus.predios.get(campus.getIDPredioStr("UAC"));
			predio.addSala("S1");
			predio.addSala("S2");
			predio.addSala("S3");
			predio.addSala("S4");
			predio.addSala("S5");
			predio.addSala("S6");
			predio.addSala("S7");
			predio.addSala("S8");
			predio.addSala("S9");
			predio.addSala("S10");
			predio.addSala("I1");
			predio.addSala("I2");
			predio.addSala("I3");
			predio.addSala("I4");
			predio.addSala("I5");
			predio.addSala("I6");
			predio.addSala("I7");
			predio.addSala("I8");
			predio.addSala("I9");
			predio.addSala("I10");
			campus.addDisciplina("Orientação a Objeto", 4);
			disciplina = campus.disciplinas.get(campus.getIDDisciplinaStr("Orientação a Objeto"));
			disciplina.addTurma("A");
			disciplina.addTurma("B");
			disciplina.addTurma("C");
			disciplina.addTurma("D");
			campus.addDisciplina("Princípios de Comunicação", 6);
			disciplina = campus.disciplinas.get(campus.getIDDisciplinaStr("Princípios de Comunicação"));
			disciplina.addTurma("A");
			campus.addDisciplina("Cálculo 3", 6);
			disciplina = campus.disciplinas.get(campus.getIDDisciplinaStr("Cálculo 3"));
			disciplina.addTurma("A");
			disciplina.addTurma("B");
			disciplina.addTurma("C");
			disciplina.addTurma("D");
			uni.infUniver();
			System.out.println("Populado!");
			
			
		} else {
			uni = new Universidade("UnB");
		}
		
		while(true) {
			System.out.println("\n\n\n----------------------------------------------------------- ");
			System.out.println("\n\nInforme o número da operação que deseja realizar: \n");
			System.out.println("(1)  Mapa da universidade: ");
			System.out.println("(2)  Adicionar novo campus");
			System.out.println("(3)  Remover Campus");
			System.out.println("(4)  Editar Campus");
			System.out.println("(5)  Adicionar Alunos");
			System.out.println("(6)  Adicionar Professor");
			System.out.println("(7)  Editar matriculado");
			System.out.println("(8)  Remover matriculado");
			System.out.println("(9)  Adicionar novo prédio");
			System.out.println("(10) Remover prédio");
			System.out.println("(11) Editar prédio");
			System.out.println("(12) Adicionar nova disciplina");
			System.out.println("(13) Remover disciplina");
			System.out.println("(14) Editar disciplina");
			System.out.println("(15) Adicionar nova turma");
			System.out.println("(16) Remover turma");
			System.out.println("(17) Editar turma");
			System.out.println("(18) Adicionar nova sala");
			System.out.println("(19) Remover sala");
			System.out.println("(20) Editar sala");
			System.out.println("(99) Para sair.");
			menu = in.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("Selecionado: (1) Mapa da universidade: ");
					uni.infUniver();
					break;
					
				case 2:
					System.out.println("Selecionado: (2) Adicionar novo campus");
					System.out.println("Digite o nome do novo campus");
					in.nextLine();
					String temp = in.nextLine();
					uni.addCampus(temp);
					break;
					
				case 3:
					System.out.println("Selecionado: (3) Remover Campus");
					System.out.println("Digite o nome do Campus que deseja remover.");
					in.nextLine();
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) 
						uni.campus.remove(uni.getIDCampusStr(temp));
					else 
						System.out.println("Campus não encontrado!");
					break;
					
				case 4:
					System.out.println("Selecionado: (4) Editar Campus");
					System.out.println("Digite o nome do Campus que deseja Editar.");
					in.nextLine();
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						System.out.println("Digite o novo nome do Campus.");
						temp = in.nextLine();
						campus.setNome(temp);
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 5:
					System.out.println("Selecionado: (5) Adicionar Alunos");
					in.nextLine();
					System.out.println("Digite o nome do aluno.");
					temp = in.nextLine();
					System.out.println("Digite a matrícula do aluno");
					String temp2 = in.nextLine();
					uni.addAluno(temp, temp2);
					break;
				
				case 6:
					System.out.println("Selecionado: (6) Adicionar professor");
					in.nextLine();
					System.out.println("Digite o nome do professor.");
					temp = in.nextLine();
					System.out.println("Digite a matrícula do professor");
					temp2 = in.nextLine();
					uni.addProfessor(temp, temp2);
					break;
				
				case 7:
					System.out.println("Selecionado: (7) Editar matriculado");
					in.nextLine();
					System.out.println("Digite a matrícula para ser pesquisada.");
					temp = in.nextLine();
					if(uni.getIDMatriculadoStr(temp)>-1) {
						matriculado = uni.matriculado.get(uni.getIDMatriculadoStr(temp));
						if(matriculado.isProfessor()) 
							System.out.println(matriculado.nome + "|Professor|" + matriculado.matricula);
						else
							System.out.println(matriculado.nome + "|Aluno|" + matriculado.matricula);
						System.out.println("Digite a nova matrícula.");
						temp = in.nextLine();
						matriculado.setMatricula(temp);
					} else {
						System.out.println("Matricula não encontrada.");
					}
					break;

				case 8:
					System.out.println("Selecionado: (8) Remover matriculado");
					in.nextLine();
					System.out.println("Digite a matrícula para ser pesquisada.");
					temp = in.nextLine();
					if(uni.getIDMatriculadoStr(temp)>-1) 
						uni.matriculado.remove(uni.getIDMatriculadoStr(temp));
					else 
						System.out.println("Matricula não encontrada.");
					break;
					
				case 9:
					System.out.println("Selecionado: (9) Adicionar Prédio");
					in.nextLine();
					System.out.println("Digite o campus em que se deve adicionar o prédio.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome do prédio a ser adicionado.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						campus.addPredio(temp);
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 10:
					System.out.println("Selecionado: (10) Remover Prédio");
					in.nextLine();
					System.out.println("Digite o campus ao qual o prédio pertence.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome do prédio a ser removido.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDPredioStr(temp)>-1) {
							campus.removePredio(campus.getIDPredioStr(temp));
						} else {
							System.out.println("Prédio não encontrado!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 11:
					System.out.println("Selecionado: (11) Editar Prédio");
					in.nextLine();
					System.out.println("Digite o campus ao qual o prédio pertence.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome do prédio a ser editado.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDPredioStr(temp)>-1) {
							predio = campus.predios.get(campus.getIDPredioStr(temp));
							System.out.println("Digite o novo nome do prédio.");
							temp = in.nextLine();
							predio.setNome(temp);
						} else {
							System.out.println("Prédio não encontrado!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;

				case 12:
					System.out.println("Selecionado: (12) Adicionar disciplina");
					in.nextLine();
					System.out.println("Digite o campus ao qual se deseja inserir uma disciplina.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome da disciplina a ser adicionada.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						System.out.println("Digite a quantidade de créditos da disciplina.");
						int temp3 = in.nextInt();
						campus.addDisciplina(temp, temp3);
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;

				case 13:
					System.out.println("Selecionado: (13) Remover disciplina");
					in.nextLine();
					System.out.println("Digite o campus ao qual se deseja remover uma disciplina.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome da disciplina a ser removida.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDDisciplinaStr(temp)>-1) {
							campus.disciplinas.remove(campus.getIDDisciplinaStr(temp));
						} else {
							System.out.println("Disciplina não encontrada!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 14:
					System.out.println("Selecionado: (14) Editar disciplina");
					in.nextLine();
					System.out.println("Digite o campus ao qual a disciplina pertence.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome da disciplina a ser editada.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDDisciplinaStr(temp)>-1) {
							disciplina = campus.disciplinas.get(campus.getIDDisciplinaStr(temp));
							System.out.println(disciplina.nome + " | créditos: " + disciplina.credito);
							System.out.println("Digite o novo nome da disciplina.");
							temp = in.nextLine();
							disciplina.setNome(temp);
							System.out.println("Digite a nova quantidade de créditos da disciplina.");
							int temp3 = in.nextInt();
							disciplina.setCredito(temp3);
						} else {
							System.out.println("Disciplina não encontrada!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 15:
					System.out.println("Selecionado: (15) Adicionar turma");
					in.nextLine();
					System.out.println("Digite o campus ao qual a turma deve ser adicionada.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome da disciplina ao qual ao qual a turma deve ser adicionada.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDDisciplinaStr(temp)>-1) {
							disciplina = campus.disciplinas.get(campus.getIDDisciplinaStr(temp));
							System.out.println("Digite o nome da turma a ser adicionada");
							temp = in.nextLine();
							disciplina.addTurma(temp);
						} else {
							System.out.println("Disciplina não encontrada!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 16:
					System.out.println("Selecionado: (16) Remover turma");
					in.nextLine();
					System.out.println("Digite o campus ao qual a turma deve ser removida.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome da disciplina ao qual ao qual a turma deve ser removida.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDDisciplinaStr(temp)>-1) {
							disciplina = campus.disciplinas.get(campus.getIDDisciplinaStr(temp));
							System.out.println("Digite o nome da turma a ser removida.");
							temp = in.nextLine();
							if(disciplina.getIDTurmaStr(temp)>-1) {
								disciplina.turmas.remove(disciplina.getIDTurmaStr(temp));
							} else {
								System.out.println("Turma não encontrada!");
							}
						} else {
							System.out.println("Disciplina não encontrada!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 17:
					System.out.println("Selecionado: (17) Editar turma");
					in.nextLine();
					System.out.println("Digite o campus ao qual a turma pertence.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						System.out.println("Digite o nome da disciplina ao qual ao qual a turma pertence.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDDisciplinaStr(temp)>-1) {
							disciplina = campus.disciplinas.get(campus.getIDDisciplinaStr(temp));
							System.out.println("Digite o nome da turma a ser editada.");
							temp = in.nextLine();
							if(disciplina.getIDTurmaStr(temp)>-1) {
								turma = disciplina.turmas.get(disciplina.getIDTurmaStr(temp));
								System.out.println("Digite o novo nome da turma.");
								temp = in.nextLine();
								turma.setNome(temp);
							} else {
								System.out.println("Turma não encontrada!");
							}
						} else {
							System.out.println("Disciplina não encontrada!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 18:
					System.out.println("Selecionado: (18) Adicionar nova sala");
					in.nextLine();
					System.out.println("Digite o campus ao qual a sala deve ser adicionada a sala.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						System.out.println("Digite o nome do prédio ao qual deve ser editadoadicionado a sala.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDPredioStr(temp)>-1) {
							predio = campus.predios.get(campus.getIDPredioStr(temp));
							System.out.println("Digite o nome da sala a ser adicionada.");
							temp = in.nextLine();
							predio.addSala(temp);
						} else {
							System.out.println("Prédio não encontrado!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 19:
					System.out.println("Selecionado: (19) Remover nova sala");
					in.nextLine();
					System.out.println("Digite o campus ao qual a sala deve ser adicionada.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						System.out.println("Digite o nome do prédio ao qual a sala deve ser adicionado.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDPredioStr(temp)>-1) {
							predio = campus.predios.get(campus.getIDPredioStr(temp));
							System.out.println("Digite o nome da sala a ser removida.");
							temp = in.nextLine();
							if(predio.getIDSalaStr(temp)>-1) {
								predio.salas.remove(predio.getIDSalaStr(temp));
							} else {
								System.out.println("Sala não encontrado!");
							}
						} else {
							System.out.println("Prédio não encontrado!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 20:
					System.out.println("Selecionado: (20) Editar nova sala");
					in.nextLine();
					System.out.println("Digite o campus ao qual a sala deve ser editada.");
					temp = in.nextLine();
					if(uni.getIDCampusStr(temp)>-1) {
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						System.out.println("Digite o nome do prédio ao qual a sala deve ser editada.");
						campus = uni.campus.get(uni.getIDCampusStr(temp));
						temp = in.nextLine();
						if(campus.getIDPredioStr(temp)>-1) {
							predio = campus.predios.get(campus.getIDPredioStr(temp));
							System.out.println("Digite o nome da sala a ser editada.");
							temp = in.nextLine();
							if(predio.getIDSalaStr(temp)>-1) {
								sala = predio.salas.get(predio.getIDSalaStr(temp));
								System.out.println("Digite o novo nome da sala.");
								temp = in.nextLine();
								sala.setNome(temp);
							} else {
								System.out.println("Sala não encontrado!");
							}
						} else {
							System.out.println("Prédio não encontrado!");
						}
					} else {
						System.out.println("Campus não encontrado!");
					}
					break;
					
				case 99:
					System.out.println("Programa Terminado!");
					System.exit(1);
					break;
				
			}
		}
	}
}