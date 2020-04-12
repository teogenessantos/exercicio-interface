package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import mobel.interfaces.OnlinePaymentService;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	private static Calendar calendar = Calendar.getInstance();
	private Date date = new Date();
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		Double valorSimplesParcela = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			Double monthlySimple = onlinePaymentService.interest(valorSimplesParcela, i);
			Double paymentFee = onlinePaymentService.paymentFee(monthlySimple);
			calendar.add(Calendar.DATE, months*30);
			Installment installment = new Installment(calendar.getTime(), paymentFee);
			contract.addInstallment(installment);
		}
	}
}
