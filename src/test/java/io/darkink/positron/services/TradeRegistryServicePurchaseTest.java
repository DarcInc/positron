package io.darkink.positron.services;

import io.darkink.positron.data.positions.PositionRepository;
import io.darkink.positron.data.symbols.Symbol;
import io.darkink.positron.data.symbols.SymbolRepository;
import io.darkink.positron.data.symbols.SymbolType;
import io.darkink.positron.data.trades.Trade;
import io.darkink.positron.data.trades.TradeRepository;
import io.darkink.positron.data.trades.TransType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class TradeRegistryServicePurchaseTest {
    private TradeRegistryService tradeRegistryService;
    @MockBean
    TradeRepository tradeRepository;
    @MockBean
    PositionRepository positionRepository;
    @MockBean
    SymbolRepository symbolRepository;

    private static final Date tradedOn = new Date();
    private static final Date recordedOn = new Date();

    public TradeRegistryServicePurchaseTest() {
        this.tradeRegistryService = new TradeRegistryServiceImpl(tradeRepository, positionRepository, symbolRepository);
    }

    @BeforeEach
    void setUp() {

        Trade resultingTrade = new Trade(100L, "AMZN", TransType.Buy, tradedOn, recordedOn, 100L,
                new BigDecimal("12345.23"));
        Symbol resultingSymbol = new Symbol("AMZN", SymbolType.EQUITY, "US");
        Mockito.when(tradeRepository.save("AMZN", TransType.Buy, tradedOn, 100L,
                new BigDecimal("12345.23"))).thenReturn(resultingTrade);
        Mockito.when(symbolRepository.findByticker("AMZN")).thenReturn(Optional.of(resultingSymbol));
    }

    @Test
    public void simplePurchase() {
        TradeDetails details = tradeRegistryService.registerPurchase("AMZN", 100L,
                new BigDecimal("12345.23"));

        assertEquals(100L, details.getId());
        assertEquals(details.getTicker().getTicker(), "AMZN");
        assertEquals(details.getTicker().getSymbolType(), SymbolType.EQUITY);
        assertEquals(details.getTicker().getExchange(), "US");
        assertEquals(details.getTransaction(), "purchase");
    }
}
