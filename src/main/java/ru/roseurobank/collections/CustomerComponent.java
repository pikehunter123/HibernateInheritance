package ru.roseurobank.collections;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author zadorozhniy276
 */
@Entity
@Table(name = "CUSTOMER_TABLE")
public class CustomerComponent {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CUSTOMER_NAME")
    private String name;

    @Embedded
    private Address address;

//    public CustomerComponent() {
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
