package model.services;

import java.util.Calendar;

import mobel.interfaces.OnlinePaymentService;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	private static Calendar calendar = Calendar.getInstance();
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		Double valorSimplesParcela = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			Double monthlySimple = onlinePaymentService.interest(valorSimplesParcela, i);
			Double paymentFee = onlinePaymentService.paymentFee(monthlySimple);
			calendar.setTime(contract.getDate());
			calendar.add(Calendar.MONTH, i);
			Installment installment = new Installment(calendar.getTime(), paymentFee);
			contract.addInstallment(installment);
		}
	}
}
