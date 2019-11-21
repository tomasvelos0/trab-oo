package pacote;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Deseja criar uma universidade?: ");
		System.out.println("(1)Sim\n(2)Não");
		int r = in.nextInt();
		if (r==1) {
			System.out.println("Qual o nome da universidade? ");
			String s = in.next();
			Universidade uni = new Universidade(s);
			System.out.println(s + " criado com sucesso");
			System.out.println("Quantos campus a universidade possuirá? ");
			int c = in.nextInt();
			for(int i=0; i<c; i++) {
				System.out.println("Nome do campus: ");
				String ss = in.next();
				uni.addCampus(ss);
			}
			
			while (c!=11) {
				c = in.nextInt();
				System.out.println("As opções que que a universidade possui:");
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
				
				System.out.println("\n Informe o número para o que deseja realizar: \n\n");
				if(c==1) {
					System.out.println("(1) Adicionar novo campus");
				}
				else if(c==2) {
					System.out.println("(2) Remover Campus");
				}
				else if(c==3) {
					System.out.println("(3) Editar Campus");
				}
				else if(c==4) {
					System.out.println("(3) Editar Campus");
				}
				else if(c==5) {
					System.out.println("(5) Adicionar ALunos");
				}
				else if(c==6) {
					System.out.println("(6) Adicionar Professor");
				}
				else if(c==7) {
					System.out.println("(7) Gerar id Alunos");
				}
				else if(c==8) {
					System.out.println("(8) Gerar id Professor");
				}
				else if(c==9) {
					System.out.println("(9) Editar staff");
				}
				else if(c==10) {
					System.out.println("(10) Informações da universidade: ");
					uni.infUniver();
				}
			}
		}
		
		
	}
}