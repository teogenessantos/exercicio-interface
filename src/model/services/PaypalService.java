package model.services;

import mobel.interfaces.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService{

	@Override
	public Double paymentFee(Double amount) {
		amount += amount*0.02;
		return amount;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		amount += (amount*0.01)*months;
		return amount;
	}
	
}
