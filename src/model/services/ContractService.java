package model.services;

import mobel.interfaces.OnlinePaymentService;
import model.entities.Contract;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
	}
}
