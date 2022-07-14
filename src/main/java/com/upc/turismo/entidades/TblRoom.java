package com.upc.turismo.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_room")
public class TblRoom implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "beds", nullable = false)
    private Integer beds;

    @Column(name = "number", nullable = false, length = 25)
    private String number;

    @Column(name = "state", nullable = false)
    private Boolean state = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}