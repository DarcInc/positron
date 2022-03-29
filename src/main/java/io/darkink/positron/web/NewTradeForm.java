package io.darkink.positron.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewTradeForm {
    private String ticker;
    private String transType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;
    private Long units;
    private BigDecimal price;
}
