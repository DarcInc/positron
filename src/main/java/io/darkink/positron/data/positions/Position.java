package io.darkink.positron.data.positions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Position {
    private String ticker;
    private Long quantity;
    private BigDecimal basis;
}
