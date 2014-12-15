package ru.roseurobank.hibernateinheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AttributeOverride(name = "owner", column
        = @Column(name = "CC_OWNER", nullable = false)
)
public class CreditCardTPCCwithIP extends BillingDetailsTPCCwithIP {

    @Id
    @GeneratedValue
    @Column(name = "CREDIT_CARD_ID")
    private Long id = null;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    public CreditCardTPCCwithIP() {
    }

    public CreditCardTPCCwithIP(String owner, String number) {
        super(owner);
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
