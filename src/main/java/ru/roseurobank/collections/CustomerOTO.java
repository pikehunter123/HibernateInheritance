package ru.roseurobank.collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 *
 * @author zadorozhniy276
 */
@Entity
@Table(name = "CUSTOMER_TABLE")
public class CustomerOTO {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "CUSTOMER_NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @JoinColumn(name = "ADDRESS_ID")
    @JoinTable(
        name = "ITEM_CUSTOMER",
        joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
        inverseJoinColumns = @JoinColumn(name = "ADDERSS_ID")
    )
    private AddressOTO address;

//    public CustomerOTO() {
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

    public AddressOTO getAddress() {
        return address;
    }

    public void setAddress(AddressOTO address) {
        this.address = address;
    }
}
