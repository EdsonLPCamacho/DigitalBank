package com.digitalbank.app.bankingoperations;

import com.digitalbank.app.entity.Client;

public class BasicOperations {
    public void performBasicOperation(Client client, String operationType, double amount) {
        switch (operationType) {
            case "Deposit":
                deposit(client, amount);
                break;
            case "Withdrawal":
                withdrawal(client, amount);
                break;
            // Add more cases for other operations as needed
            default:
                System.out.println("Invalid operation type.");
                break;
        }
    }

    private void deposit(Client client, double amount) {
        // Perform deposit operation
        double currentBalance = client.getBalance();
        client.setBalance(currentBalance + amount);
        System.out.println("Deposit successful. New balance: $" + client.getBalance());
    }

    private void withdrawal(Client client, double amount) {
        // Perform withdrawal operation
        double currentBalance = client.getBalance();
        if (currentBalance >= amount) {
            client.setBalance(currentBalance - amount);
            System.out.println("Withdrawal successful. New balance: $" + client.getBalance());
        } else {
            System.out.println("Withdrawal failed: Insufficient balance.");
        }
    }
}

