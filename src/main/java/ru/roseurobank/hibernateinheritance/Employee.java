package ru.roseurobank.hibernateinheritance;

import java.util.Date;
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
@Table(name = "EMPLOYEE")
//@AttributeOverrides({
//    @AttributeOverride(name = "firstname", column = @Column(name = "FIRSTNAME")),
//    @AttributeOverride(name = "lastname", column = @Column(name = "LASTNAME"))
//})
//@PrimaryKeyJoinColumn(name="PERSON_ID")
@DiscriminatorValue("E")
public class Employee extends Person {

    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "department_name")
    private String departmentName;

    public Employee() {
    }

    public Employee(String firstname, String lastname, String departmentName, Date joiningDate) {

        super(firstname, lastname);

        this.departmentName = departmentName;
        this.joiningDate = joiningDate;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
