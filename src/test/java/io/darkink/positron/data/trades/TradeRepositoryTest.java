package io.darkink.positron.data.trades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TradeRepositoryTest {
    private JdbcTemplate jdbcTemplate;
    private TradeRepository tradeRepository;

    public TradeRepositoryTest() {
        jdbcTemplate = mock(JdbcTemplate.class);
        tradeRepository = new TradeRepositoryImpl(jdbcTemplate);
    }

    @BeforeEach
    public void setUp() {
        Date currentDate = new Date();

        Trade t1 = new Trade(100L, "AMZN", TransType.Buy, currentDate, currentDate, 100L, new BigDecimal("1234.23"));
        Trade t2 = new Trade(101L, "AMZN", TransType.Buy, currentDate, currentDate, 100L, new BigDecimal("1234.23"));
        Trade t3 = new Trade(102L, "AMZN", TransType.Sell, currentDate, currentDate, 100L, new BigDecimal("1234.23"));
        when(jdbcTemplate.query(eq(TradeRepositoryImpl.ALL_TRADES), any(TradeRowMapper.class)))
                .thenReturn(List.of(t1, t2, t3));
    }


    @Test
    public void simpleAllTrades() {
        List<Trade> trades = tradeRepository.allTrades();
        assertEquals(3, trades.size());

    }
}
