package application;

import model.entities.DomainException;
import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex49 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Room number:");
            int roomNumber = scanner.nextInt();
            System.out.print("Check-in (dd/mm/yyyy): ");
            Date checkIn = simpleDateFormat.parse(scanner.next());
            System.out.print("Check-out (dd/mm/yyyy): ");
            Date checkOut = simpleDateFormat.parse(scanner.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation:" + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation ");
            System.out.print("Check-in (dd/mm/yyyy):");
            checkIn = simpleDateFormat.parse(scanner.next());
            System.out.print("Check-out (dd/mm/yyyy):");
            checkOut = simpleDateFormat.parse(scanner.next());

            reservation.updateDate(checkIn, checkOut);
            System.out.println("Reservation " + reservation);
        }
        catch (ParseException exception){
            System.out.println("Invalid date format");
        }
        catch (DomainException exception){
            //getMessage() para pegar a String do método
            System.out.println("Error in reservation" + exception.getMessage());
        }
        catch (RuntimeException exception){
            System.out.println("Unexpected error");

        }

        scanner.close();

    }
}
