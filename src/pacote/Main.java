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
			for(int i = 0; i < c; i++) {
				System.out.println("Nome do campus[" + i + "]: ");
				String ss = in.next();
				uni.addCampus(ss);
				System.out.println("Campus " + ss + " criado com sucesso.");
			}
		}
		
		
	}
}