package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private String trade_type;
    private String trade_currency;
    private int quantity;
    private Date trade_settlement_date;
    private String trade_status;
    private Date trade_date;
    private BigDecimal unit_price;
    private BigDecimal coupon_percent;
    private String bond_currency;
    private String cusip;
    private int face_value_mn;
    private String isin;

    @ManyToOne
    @JoinColumn(name = "issuer_id")
    private Users issuer;

    private Date bond_maturity_date;
    private String status;
    private String type;

    @ManyToOne
    @JoinColumn(name = "bond_holder_id")
    private Users bond_holder;

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Trade(Long tradeId, Book book, String trade_type, String trade_currency, int quantity,
                 Date trade_settlement_date, String trade_status, Date trade_date, BigDecimal unit_price,
                 BigDecimal coupon_percent, String bond_currency, String cusip, int face_value_mn,
                 String isin, Users issuer, Date bond_maturity_date, String status, String type, Users bond_holder) {
        this.tradeId = tradeId;
        this.book = book;
        this.trade_type = trade_type;
        this.trade_currency = trade_currency;
        this.quantity = quantity;
        this.trade_settlement_date = trade_settlement_date;
        this.trade_status = trade_status;
        this.trade_date = trade_date;
        this.unit_price = unit_price;
        this.coupon_percent = coupon_percent;
        this.bond_currency = bond_currency;
        this.cusip = cusip;
        this.face_value_mn = face_value_mn;
        this.isin = isin;
        this.issuer = issuer;
        this.bond_maturity_date = bond_maturity_date;
        this.status = status;
        this.type = type;
        this.bond_holder = bond_holder;
    }

    public Trade() {
    }

    public Long getTrade_id() {
        return tradeId;
    }

    public void setTrade_id(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTrade_currency() {
        return trade_currency;
    }

    public void setTrade_currency(String trade_currency) {
        this.trade_currency = trade_currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTrade_settlement_date() {
        return trade_settlement_date;
    }

    public void setTrade_settlement_date(Date trade_settlement_date) {
        this.trade_settlement_date = trade_settlement_date;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public BigDecimal getCoupon_percent() {
        return coupon_percent;
    }

    public void setCoupon_percent(BigDecimal coupon_percent) {
        this.coupon_percent = coupon_percent;
    }

    public String getBond_currency() {
        return bond_currency;
    }

    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public int getFace_value_mn() {
        return face_value_mn;
    }

    public void setFace_value_mn(int face_value_mn) {
        this.face_value_mn = face_value_mn;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Users getIssuer() {
        return issuer;
    }

    public void setIssuer(Users issuer) {
        this.issuer = issuer;
    }

    public Date getBond_maturity_date() {
        return bond_maturity_date;
    }

    public void setBond_maturity_date(Date bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Users getBond_holder() {
        return bond_holder;
    }

    public void setBond_holder(Users bond_holder) {
        this.bond_holder = bond_holder;
    }
}
