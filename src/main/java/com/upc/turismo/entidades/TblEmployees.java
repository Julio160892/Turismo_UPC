package com.upc.turismo.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_employees")
public class TblEmployees implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "surnames", nullable = false)
    private String surnames;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "state", nullable = false)
    private Boolean state = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}