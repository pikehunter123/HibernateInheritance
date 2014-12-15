package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CreditCardTPCH extends BillingDetailsTPCH {

    @Column(name = "CC_NUMBER")
    private String number;

    public CreditCardTPCH() {
    }

    public CreditCardTPCH(String owner, String number) {
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
