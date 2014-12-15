package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetailsTPS {

    @Id
    @GeneratedValue
    @Column(name = "BILLING_DETAILS_ID")
    private Long id = null;

    @Column(name = "OWNER", nullable = false)
    private String owner;

    public BillingDetailsTPS() {
    }

    public BillingDetailsTPS(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
