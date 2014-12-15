package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
public class BankAccountMix extends BillingDetailsMix {

    @Column(name = "BA_ACCOUNT")
    private String account;

    public BankAccountMix() {
    }

    public BankAccountMix(String owner, String account) {
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
