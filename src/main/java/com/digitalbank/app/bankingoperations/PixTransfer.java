package com.digitalbank.app.bankingoperations;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import com.digitalbank.app.entity.Client;

@Entity
public class PixTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private LocalDateTime timestamp;

    @ManyToOne
    private Client sender;

    @ManyToOne
    private Client receiver;
    	    
 

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }
    
    
    public void transferViaPix(Client sender, Client receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();

        if (sender.getBalance() >= amount) {
            // Deduct the transfer amount from the sender's balance
            sender.setBalance(sender.getBalance() - amount);

            // Add the transfer amount to the receiver's balance
            receiver.setBalance(receiver.getBalance() + amount);

            // Print transfer details
            System.out.println("Transfer successful via Pix:");
            System.out.println("Sender: " + sender.getName());
            System.out.println("Receiver: " + receiver.getName());
            System.out.println("Amount transferred: $" + amount);
        } else {
            // Print insufficient balance message
            System.out.println("Transfer failed: Insufficient balance in sender's account.");
        }
    }
}
