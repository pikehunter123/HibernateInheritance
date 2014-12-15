package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "BANK_ACCOUNT_ID")
public class BankAccountTPS extends BillingDetailsTPS {

    @Column(name = "BA_ACCOUNT")
    private String account;

    public BankAccountTPS() {
    }

    public BankAccountTPS(String owner, String account) {
        super(owner);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
