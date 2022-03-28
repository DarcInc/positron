package io.darkink.positron.data.trades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trade {
    public Long id;
    public String ticker;
    public TransType transType;
    public Date eventDate;
    public Date recordedOn;
    public Long units;
    public BigDecimal price;
}
