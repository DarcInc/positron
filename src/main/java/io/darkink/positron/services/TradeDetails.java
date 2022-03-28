package io.darkink.positron.services;

import io.darkink.positron.data.symbols.Symbol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TradeDetails {
    private Long id;
    private Symbol ticker;
    private String transaction;
    private Date eventDate;
    private Date recordedOn;
    private Long units;
    private BigDecimal price;
}
