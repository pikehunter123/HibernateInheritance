package ru.roseurobank.hibernateinheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AttributeOverride(name = "owner", column
        = @Column(name = "BA_OWNER", nullable = false)
)
public class BankAccountTPCCwithIP extends BillingDetailsTPCCwithIP {

    @Id
    @GeneratedValue
    @Column(name = "BANK_ACCOUNT_ID")
    private Long id = null;

    @Column(name = "BA_ACCOUNT", nullable = true)
    private String account;

    public BankAccountTPCCwithIP() {
    }

    public BankAccountTPCCwithIP(String owner, String account) {
        super(owner);
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
