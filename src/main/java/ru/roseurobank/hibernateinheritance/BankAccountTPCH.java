package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
public class BankAccountTPCH extends BillingDetailsTPCH {

    @Column(name = "BA_ACCOUNT")
    private String account;

    public BankAccountTPCH() {
    }

    public BankAccountTPCH(String owner, String account) {
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
