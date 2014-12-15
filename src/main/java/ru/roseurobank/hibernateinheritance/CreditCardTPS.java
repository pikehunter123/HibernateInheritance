package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "CREDIT_CARD_ID")
public class CreditCardTPS extends BillingDetailsTPS {

    @Column(name = "CC_NUMBER")
    private String number;

    public CreditCardTPS() {
    }

    public CreditCardTPS(String owner, String number) {
        super(owner);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
