package io.darkink.positron.data.positions;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PositionRepositoryTests {
    @Test
    public void simpleListAllPositions() {
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        when(jdbcTemplate.query(eq(PositionRepositoryImpl.ALL_POSITIONS), any(PositionRowMapper.class)))
                .thenReturn(
                        List.of(
                                new Position("AMZN", 1000L, new BigDecimal("12345.23")),
                                new Position("MSFT", 300L, new BigDecimal("23456.23"))));

        PositionRepository positionRepository = new PositionRepositoryImpl(jdbcTemplate);
        List<Position> actualPositions = positionRepository.allPositions();

        assertEquals(2, actualPositions.size());
        assertEquals("AMZN", actualPositions.get(0).getTicker());
        assertEquals(1000L, actualPositions.get(0).getQuantity());
        assertEquals("MSFT", actualPositions.get(1).getTicker());
        assertEquals(new BigDecimal("23456.23"), actualPositions.get(1).getBasis());
    }
}
