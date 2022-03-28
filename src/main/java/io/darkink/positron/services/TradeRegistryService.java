package io.darkink.positron.services;

import java.math.BigDecimal;

public interface TradeRegistryService {
    TradeDetails registerSale(String ticker, Long quantity, BigDecimal price);
    TradeDetails registerPurchase(String ticker, Long quantity, BigDecimal price);
}
