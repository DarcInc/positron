package io.darkink.positron.data.trades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TradeRepository {
    List<Trade> allTrades();
    Trade save(String ticker, TransType transType, Date eventDate, Long units, BigDecimal price);
}
