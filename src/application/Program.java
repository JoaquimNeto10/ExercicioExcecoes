package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Entre com os dados da conta");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaque = sc.nextDouble();
		
		Conta conta = new Conta(numero, titular, saldo, limiteSaque);
		
		System.out.println();
		System.out.print("Entre com o valor do saque: ");
		double saque = sc.nextDouble();
		
		try {
			conta.sacar(saque);
			System.out.printf("Novo saldo:  %.2f%n", conta.getSaldo());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		
		sc.close();
	}

}
