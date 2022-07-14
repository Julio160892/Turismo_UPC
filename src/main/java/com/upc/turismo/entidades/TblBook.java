package com.upc.turismo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tbl_book")
public class TblBook implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "star_date", nullable = false, length = 11)
    private Instant starDate;

    @Column(name = "end_date", nullable = false, length = 11)
    private Instant endDate;

    @Column(name = "people_quantity", nullable = false, length = 10)
    private String peopleQuantity;

    @Column(name = "price", precision = 10)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "room_id", nullable = false, referencedColumnName = "id")
    //@MapsId("id")
    @JsonIgnore
    private TblRoom room;
    //private List<TblRoom> room;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "payment_method_id", nullable = false, referencedColumnName = "id")
    //@MapsId("id")
    @JsonIgnore
    private TblPaymentMethod paymentMethod;
    //private List<TblPaymentMethod> paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    //@MapsId("id")
    @JsonIgnore
    private TblCustomer customer;
    //private List<TblCustomer> customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getStarDate() {
        return starDate;
    }

    public void setStarDate(Instant starDate) {
        this.starDate = starDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public String getPeopleQuantity() {
        return peopleQuantity;
    }

    public void setPeopleQuantity(String peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TblRoom getRoom() {
        return room;
    }

    public void setRoom(TblRoom room) {
        this.room = room;
    }

    public TblPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(TblPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public TblCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TblCustomer customer) {
        this.customer = customer;
    }

}