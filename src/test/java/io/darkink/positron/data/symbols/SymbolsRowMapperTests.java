package io.darkink.positron.data.symbols;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SymbolsRowMapperTests {
    @Test
    public void testUSEquityMapping() {
        assertDoesNotThrow(() -> {
            ResultSet rs = mock(ResultSet.class);
            when(rs.getString("ticker")).thenReturn("PG");
            when(rs.getString("symbol_type")).thenReturn("equity");
            when(rs.getString("exchange")).thenReturn("US");

            SymbolRowMapper symbolRowMapper = new SymbolRowMapper();
            Symbol actual = symbolRowMapper.mapRow(rs, 1);

            assertEquals("PG", actual.getTicker());
            assertEquals(SymbolType.EQUITY, actual.getSymbolType());
            assertEquals("US", actual.getExchange());
        });
    }
}
