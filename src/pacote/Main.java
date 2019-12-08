package pacote;

import java.util.Scanner;

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
		
		
		while (menu!=11) {
			System.out.println("\n Informe o número para o que deseja realizar: \n\n");
			System.out.println("(1) Adicionar novo campus");
			System.out.println("(2) Remover Campus");
			System.out.println("(3) Editar Campus");
			System.out.println("(4) Gerar id do Campus");
			System.out.println("(5) Adicionar ALunos");
			System.out.println("(6) Adicionar Professor");
			System.out.println("(7) Gerar id Alunos");
			System.out.println("(8) Gerar id Professor");
			System.out.println("(9) Editar staff");
			System.out.println("(10) Informações da universidade: ");
			System.out.println("(11) Para sair.");
			menu = in.nextInt();
			if(menu==1) {
				System.out.println("Selecionado: (1) Adicionar novo campus");
			}
			else if(menu==2) {
				System.out.println("Selecionado: (2) Remover Campus");
			}
			else if(menu==3) {
				System.out.println("Selecionado: (3) Editar Campus");
			}
			else if(menu==4) {
				System.out.println("Selecionado: (3) Editar Campus");
			}
			else if(menu==5) {
				System.out.println("Selecionado: (5) Adicionar Alunos");
			}
			else if(menu==6) {
				System.out.println("Selecionado: (6) Adicionar Professor");
			}
			else if(menu==7) {
				System.out.println("Selecionado: (7) Gerar id Alunos");
			}
			else if(menu==8) {
				System.out.println("Selecionado: (8) Gerar id Professor");
			}
			else if(menu==9) {
				System.out.println("Selecionado: (9) Editar staff");
			}
			else if(menu==10) {
				System.out.println("Selecionado: (10) Informações da universidade: ");
				uni.infUniver();
			}
			else if(menu==11) {
				System.out.println("Programa Terminado!");
				System.exit(1);
			} else {
				System.out.println("Número invalido!");
			}
			
		}
		in.close();
	}
}