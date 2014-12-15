package ru.roseurobank.hibernateinheritance;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetailsTPCCwithIP {

    @Column(name = "OWNER", nullable = false)
    private String owner;

    public BillingDetailsTPCCwithIP() {
    }

    public BillingDetailsTPCCwithIP(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
