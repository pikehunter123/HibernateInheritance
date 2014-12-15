package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccountTPCCwithU extends BillingDetailsTPCCwithU {

    @Column(name = "ACCOUNT", nullable = false)
    private String account;

    public BankAccountTPCCwithU() {
    }

    public BankAccountTPCCwithU(String owner, String account) {
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
