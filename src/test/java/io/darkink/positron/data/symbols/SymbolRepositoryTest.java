package io.darkink.positron.data.symbols;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class SymbolRepositoryTest {
    private JdbcTemplate jdbcTemplate;
    private SymbolRepository symbolRepository;

    public SymbolRepositoryTest() {
        jdbcTemplate = mock(JdbcTemplate.class);
        symbolRepository = new SymbolRepositoryImpl(jdbcTemplate);
    }

    @BeforeEach
    public void setUp() {
        Symbol s1 = new Symbol("AMZN", SymbolType.EQUITY, "US");
        Symbol s2 = new Symbol("BAC", SymbolType.EQUITY, "US");
        Symbol s3 = new Symbol("SPX", SymbolType.INDEX, "US");

        when(jdbcTemplate.query(eq(SymbolRepositoryImpl.ALL_SYMBOLS_QUERY), any(SymbolRowMapper.class)))
                .thenReturn(List.of(s1, s2, s3));

        when(jdbcTemplate.query(eq(SymbolRepositoryImpl.FIND_BY_TICKER_QUERY), any(SymbolRowMapper.class),
                eq("AMZN"))).thenReturn(List.of(s1));

        when(jdbcTemplate.query(eq(SymbolRepositoryImpl.FIND_BY_TICKER_QUERY), any(SymbolRowMapper.class),
                eq("XXX"))).thenReturn(List.of());
    }

    @Test
    public void testSimpleQueryAll() {
        List<Symbol> expectedSymbols = symbolRepository.allSymbols();
        assertEquals(3, expectedSymbols.size());
        assertEquals("AMZN", expectedSymbols.get(0).getTicker());
        assertEquals("BAC", expectedSymbols.get(1).getTicker());
        assertEquals("SPX", expectedSymbols.get(2).getTicker());
    }

    @Test
    public void testSimpleGetByTicker() {
        Optional<Symbol> actualSymbol = symbolRepository.findByticker("AMZN");
        assertTrue(actualSymbol.isPresent());
        assertEquals("AMZN", actualSymbol.get().getTicker());
    }

    @Test
    public void testGetByTickerNotFound() {
        Optional<Symbol> actualSymbol = symbolRepository.findByticker("XXX");
        assertTrue(actualSymbol.isEmpty());
    }
}
