package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Programa {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);

        // Solicita ao usuário informações sobre a conta.
        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine(); // Limpa o buffer do teclado.
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        // Criação de um objeto Account com as informações fornecidas.
        Account acc = new Account(number, holder, balance, withdrawLimit);
        System.out.println();
        System.out.print("Enter an amount to withdraw: ");
        double amount = sc.nextDouble();

        // Tenta realizar a operação de saque, capturando possíveis exceções BusinessException.
        try {
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f%n", acc.getBalance());
        }
        // Captura exceções do tipo BusinessException e exibe a mensagem associada.
        catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
 
        sc.close();
    }
}
