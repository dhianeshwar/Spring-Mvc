package CrudApp.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Merchant {

    @Id
    private Long accountNumber;
    private String name;
    private int balance;
    private int age;
    private String emailId;
    private int isActive= 1;

    @OneToMany(mappedBy = "senderAccountNumber", cascade = CascadeType.ALL)
    private List<FundTransaction> sentTransactions;

    @OneToMany(mappedBy = "receiverAccountNumber", cascade = CascadeType.ALL)
    private List<FundTransaction> receivedTransactions;

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FundTransaction> getSentTransactions() {
        return sentTransactions;
    }

    public void setSentTransactions(List<FundTransaction> sentTransactions) {
        this.sentTransactions = sentTransactions;
    }

    public List<FundTransaction> getReceivedTransactions() {
        return receivedTransactions;
    }

    public void setReceivedTransactions(List<FundTransaction> receivedTransactions) {
        this.receivedTransactions = receivedTransactions;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
