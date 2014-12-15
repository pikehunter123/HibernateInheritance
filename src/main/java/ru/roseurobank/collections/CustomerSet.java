package ru.roseurobank.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Order;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author zadorozhniy276
 */
@Entity
@Table(name = "T_CUSTOMER")
public class CustomerSet {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "CUSTOMER_NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    private Set<OrderSet> orders = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<OrderSet> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderSet> orders) {
        this.orders = orders;
    }
    
    public void addOrder(OrderSet order) {
        order.setCustomer(this);
        orders.add(order);
    }

}
