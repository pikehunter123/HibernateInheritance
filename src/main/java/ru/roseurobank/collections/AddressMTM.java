package ru.roseurobank.collections;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author zadorozhniy276
 */
@Entity
public class AddressMTM {

    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(name = "ADDRESS_STREET", nullable = false, length = 250)
    private String street;

    @Column(name = "ADDRESS_CITY", nullable = false, length = 50)
    private String city;

    @Column(name = "ADDRESS_STATE", nullable = false, length = 50)
    private String state;

    @Column(name = "ADDRESS_ZIPCODE", nullable = false, length = 10)
    private String zipcode;

//    @ManyToMany(mappedBy = "addressList")
//    private Set<CustomerMTM> customers = new HashSet<>();
//
//    public Set<CustomerMTM> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Set<CustomerMTM> customers) {
//        this.customers = customers;
//    }

    public String getStreet() {
        return street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
