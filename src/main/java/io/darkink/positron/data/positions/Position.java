package io.darkink.positron.data.positions;

import java.math.BigDecimal;

public class Position {
    private String ticker;
    private Long quantity;
    private BigDecimal basis;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getBasis() {
        return basis;
    }

    public void setBasis(BigDecimal basis) {
        this.basis = basis;
    }
}
