package io.darkink.positron.data.trades;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Trade {
    public BigInteger id;
    public String ticker;
    public TransType transType;
    public Date eventDate;
    public Date recordedOn;
    public BigInteger units;
    public BigDecimal price;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transType) {
        this.transType = transType;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getRecordedOn() {
        return recordedOn;
    }

    public void setRecordedOn(Date recordedOn) {
        this.recordedOn = recordedOn;
    }

    public BigInteger getUnits() {
        return units;
    }

    public void setUnits(BigInteger units) {
        this.units = units;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
