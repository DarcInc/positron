package io.darkink.positron.data.positions;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionRowMapper implements RowMapper<Position> {
    @Override
    public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
        Position result = new Position(
                rs.getString("ticker"),
                rs.getLong("total_units"),
                rs.getBigDecimal("total_basis")
        );

        return result;
    }
}
