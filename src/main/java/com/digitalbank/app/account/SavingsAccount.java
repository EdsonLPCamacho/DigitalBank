package com.digitalbank.app.account;
import com.digitalbank.app.entity.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class SavingsAccount {
    @Id
    private Long id;
    @OneToOne
    private Client client;
    private double balance;
    private double annualInterestRate;

    public SavingsAccount(Client client) {
        this.client = client;
        this.balance = 0;
        this.annualInterestRate = defineAnnualInterestRate();
    }

    private double defineAnnualInterestRate() {
        if (client.getType().equals("Common")) {
            return 0.005; // 0.5% per year
        } else if (client.getType().equals("Super")) {
            return 0.007; // 0.7% per year
        } else {
            return 0.009; // 0.9% per year for Premium clients
        }
    }

    public void calculateInterest() {
        // Calculate monthly interest rate
        double monthlyInterestRate = annualInterestRate / 12;

        // Calculate monthly interest
        double monthlyInterest = balance * monthlyInterestRate;

        // Add the interest to the balance
        balance += monthlyInterest;
    }

    // Getters and Setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

   
}