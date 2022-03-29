package io.darkink.positron.data.positions;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.ResultSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionRowMapperTests {
    @Test
    public void testRowMapping() {
        assertDoesNotThrow(() -> {
            ResultSet rs = mock(ResultSet.class);
            when(rs.getString("ticker")).thenReturn("AMZN");
            when(rs.getLong("total_units")).thenReturn(1000L);
            when(rs.getBigDecimal("total_basis")).thenReturn(new BigDecimal("12345.23"));

            PositionRowMapper positionRowMapper = new PositionRowMapper();
            Position actual = positionRowMapper.mapRow(rs, 1);

            assertEquals("AMZN", actual.getTicker());
            assertEquals(1000L, actual.getQuantity());
            assertEquals(new BigDecimal("12345.23"), actual.getBasis());
        });
    }
}
