package ru.roseurobank.hibernateinheritance;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    private String name;

    @OneToMany
    @JoinTable(name = "USER_ROLE", 
            joinColumns = @JoinColumn(name = "USER_ID"), 
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

    public Users() {
    }

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

    public Set<Role> getRols() {
        return roles;
    }

    public void setRols(Set<Role> roles) {
        this.roles = roles;
    }

}
