package ru.roseurobank.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author zadorozhniy276
 */
@Entity
public class CustomerMTM {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "CUSTOMER_NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CUSTOMER_ADDRESS",
            joinColumns = {
                @JoinColumn(name = "CUSTOMER_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "ADDRESS_ID")}
    )
    private Set<AddressMTM> addressList = new HashSet<>();

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

    public Set<AddressMTM> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<AddressMTM> addressList) {
        this.addressList = addressList;
    }

}
