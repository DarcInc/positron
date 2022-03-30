package io.darkink.positron.data.trades;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TradeRowMapperTest {
    @Test
    public void testSimpleRowMapping() {
        assertDoesNotThrow(() -> {
            Date currentDate = new Date(2022, 03, 28);
            ResultSet rs = mock(ResultSet.class);
            when(rs.getLong("id")).thenReturn(100L);
            when(rs.getString("ticker")).thenReturn("AMZN");
            when(rs.getString("trans_type")).thenReturn("B");
            when(rs.getDate("event_date")).thenReturn(currentDate);
            when(rs.getDate("recorded_on")).thenReturn(currentDate);
            when(rs.getLong("units")).thenReturn(1000L);
            when(rs.getBigDecimal("price")).thenReturn(new BigDecimal("12345.23"));

            TradeRowMapper trm = new TradeRowMapper();
            Trade row = trm.mapRow(rs, 1);

            assertEquals(100L, row.getId());
            assertEquals("AMZN", row.getTicker());
            assertEquals(TransType.Buy, row.getTransType());
            assertEquals(currentDate, row.getEventDate());
            assertEquals(currentDate, row.getRecordedOn());
            assertEquals(1000L, row.getUnits());
            assertEquals(new BigDecimal("12345.23"), row.getPrice());
        });
    }
}
