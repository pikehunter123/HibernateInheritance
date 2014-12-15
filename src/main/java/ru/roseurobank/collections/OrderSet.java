package ru.roseurobank.collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author zadorozhniy276
 */
@Entity
@Table(name = "T_ORDER")
public class OrderSet {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "ORDER_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private CustomerSet customer;

    public OrderSet() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerSet getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerSet customer) {
        this.customer = customer;
    }

}
