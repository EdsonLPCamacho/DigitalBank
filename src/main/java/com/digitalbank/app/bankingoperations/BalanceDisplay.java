package com.digitalbank.app.bankingoperations;

import com.digitalbank.app.entity.Client;

public class BalanceDisplay {

	public void displayBalance(Client client) {
        // Logic to display the client's balance
        System.out.println("Client's balance: $" + client.getBalance());
    }
	
}
