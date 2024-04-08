package com.digitalbank.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.digitalbank.app.card.CreditCard;
import com.digitalbank.app.card.DebitCard;
import com.digitalbank.app.insurance.CreditCardInsurance;
import com.digitalbank.app.insurance.FraudInsurance;
import com.digitalbank.app.insurance.TravelInsurance;

import java.time.LocalDate; // Import LocalDate from java.time
import java.util.List;


 
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	//CPF, name, date of birth, address
	private String name;
	private Long CPF;
	private LocalDate dateOfBirth;
	private String address;	
	private String type; // Com, Super or Premium
	// Defining the balance column with default value 0.0 and disallowing null values
    @Column(nullable = false, columnDefinition = "FLOAT DEFAULT 0.0")
    private double balance;
	
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
	
    @OneToMany(mappedBy = "client")
    private List<CreditCard> creditCards;
    

    @OneToMany(mappedBy = "client")
    private List<DebitCard> debitCards;
    
    @OneToOne(mappedBy = "client")
    private CreditCardInsurance creditCardInsurance;

    @OneToOne(mappedBy = "client")
    private FraudInsurance fraudInsurance;

    @OneToOne(mappedBy = "client")
    private TravelInsurance travelInsurance;

    
 
	//Getters and Setters
	
	    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

		public Client(String name, String type) {
	        this.name = name;
	        this.type = type;
	    }
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCPF() {
		return CPF;
	}
	public void setCPF(Long cPF) {
		CPF = cPF;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


}
