package com.upc.turismo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tbl_receipt")
public class TblReceipt implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_price", nullable = false, precision = 10)
    private BigDecimal totalPrice;

    @Column(name = "advance_payment", precision = 10)
    private BigDecimal advancePayment;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "receipt_state", nullable = false)
    private Boolean receiptState = false;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private TblBook book;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "employees_id", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private TblEmployees employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(BigDecimal advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Boolean getReceiptState() {
        return receiptState;
    }

    public void setReceiptState(Boolean receiptState) {
        this.receiptState = receiptState;
    }

    public TblBook getBook() {
        return book;
    }

    public void setBook(TblBook book) {
        this.book = book;
    }

    public TblEmployees getEmployees() {
        return employees;
    }

    public void setEmployees(TblEmployees employees) {
        this.employees = employees;
    }

}