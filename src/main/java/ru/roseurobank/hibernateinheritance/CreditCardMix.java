package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("CC")
@SecondaryTable(name = "CREDIT_CARD")
public class CreditCardMix extends BillingDetailsMix {

    @Column(table = "CREDIT_CARD",
            name = "CC_NUMBER",
            nullable = false)
    private String number;

    public CreditCardMix() {
    }

    public CreditCardMix(String owner, String number) {
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
