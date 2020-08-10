package exercicioFixacao;

import java.util.Locale;
import java.util.Scanner;

public class Ex50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);


        System.out.println("Enter account data");
        System.out.print("Number:");
        int number = scanner.nextInt();
        System.out.print("Holder:");
        scanner.nextLine();
        String holder = scanner.nextLine();
        System.out.print("Initial Balance:");
        double balance = scanner.nextDouble();
        System.out.print("Withdraw limit:");
        double withdraw = scanner.nextDouble();

        Acconunt acconunt = new Acconunt(number, holder,balance,withdraw);

        System.out.println();
        System.out.print("Enter amount for withdraw:");
        double amount = scanner.nextDouble();

        try {
            acconunt.withdraw(amount);
            System.out.printf("New Balance: %.2f", acconunt.getBalance());
        }
        catch (DomainException exception){
            System.out.print("Withdraw error: " + exception.getMessage());
        }

        scanner.close();

    }
}
