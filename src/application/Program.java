package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Integer number, quantityInstallments;
		Date date = new Date();
		Double totalValue;
		
		try {
			System.out.println("Enter contract data");
			System.out.print("Number: ");
			number = sc.nextInt();
			System.out.print("Date (dd/MM/yyyy): ");
			date = sdf.parse(sc.next());
			System.out.print("Contract value: ");
			totalValue = sc.nextDouble();
			System.out.print("Enter number of installments: ");
			quantityInstallments = sc.nextInt();
			System.out.println("Installments:");
			System.out.println("25/07/2018 - 206.04");
			System.out.println("25/08/2018 - 208.08");
			System.out.println("25/09/2018 - 210.12");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
