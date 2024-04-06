import com.digitalbank.app.entity.Client;
import jakarta.persistence.Entity;


public class CheckingAccount {
    private Client client;
    private double balance;
    private double maintenanceFee;

    public CheckingAccount(Client client) {
        this.client = client;
        this.balance = 0;
        this.maintenanceFee = defineMaintenanceFee();
    }

    private double defineMaintenanceFee() {
        if (client.getType().equals("Common")) {
            return 12.00;
        } else if (client.getType().equals("Super")) {
            return 8.00;
        } else {
            return 0.00; // No fee for Premium clients
        }
    }

    public void deductMaintenanceFee() {
        this.balance -= maintenanceFee;
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

    public double getMaintenanceFee() {
        return maintenanceFee;
    }

    public void setMaintenanceFee(double maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }
}
