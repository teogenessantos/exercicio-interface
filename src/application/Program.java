package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

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
			
			Contract contract = new Contract(number, date, totalValue);
			
			System.out.print("Enter number of installments: ");
			quantityInstallments = sc.nextInt();
			
			ContractService contractService = new ContractService(new PaypalService());
			contractService.processContract(contract, quantityInstallments);
			
			System.out.println("Installments:");
			for (Installment installment : contract.getListInstallment()) {
				System.out.println(sdf.format(installment.getDueDate())+" - "+installment.getAmout());
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
