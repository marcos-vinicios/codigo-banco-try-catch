package aplicacao;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Conta;
import model.excecao.DominioExcecao;

public class MenuInicial {

	public static void main(String[] args) throws DominioExcecao {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
			System.out.println("Entre com dados da conta: ");
			System.out.println("Número: ");
			int numero = sc.nextInt();
			System.out.println("Nome do correntista: ");
			sc.nextLine();
			String titular = sc.nextLine();
			System.out.println("insira o balanço inicial: ");
			double balanco = sc.nextDouble();
			System.out.println("Limite maximo de retirada: ");
			double limiteRetirada = sc.nextDouble();
			
			Conta  conta = new Conta(numero,titular,balanco,limiteRetirada);
			System.out.println();
			System.out.println("Entre com valor de saque:");
			double montante = sc.nextDouble();
		try {
			conta.saque(montante);
			System.out.println("Novo balanço: " + String.format("%.2f", conta.getBalanco()));
		}
		catch(DominioExcecao e) {
			System.out.println("Erro no saque " + e.getMessage());
		}
		
		sc.close();
	}

}
