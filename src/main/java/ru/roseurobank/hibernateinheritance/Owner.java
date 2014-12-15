package ru.roseurobank.hibernateinheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author zadorozhniy276
 */
@Entity
@Table(name = "OWNER")
//@AttributeOverrides({
//    @AttributeOverride(name = "firstname", column = @Column(name = "FIRSTNAME")),
//    @AttributeOverride(name = "lastname", column = @Column(name = "LASTNAME"))
//})
//@PrimaryKeyJoinColumn(name="PERSON_ID")
@DiscriminatorValue("O")
public class Owner extends Person {

    @Column(name = "stocks")
    private Long stocks;

    public Owner() {
    }

    public Owner(String firstname, String lastname, Long stocks) {
        super(firstname, lastname);
        this.stocks = stocks;
    }

    public Long getStocks() {
        return stocks;
    }

    public void setStocks(Long stocks) {
        this.stocks = stocks;
    }

}
