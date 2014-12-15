package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCardTPCCwithU extends BillingDetailsTPCCwithU {

    @Column(name = "NUMBER", nullable = false)
    private String number;

    public CreditCardTPCCwithU() {
    }

    public CreditCardTPCCwithU(String owner, String number) {
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
