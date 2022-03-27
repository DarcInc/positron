package io.darkink.positron.data.positions;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionRowMapper implements RowMapper<Position> {
    @Override
    public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
        Position result = new Position();

        result.setTicker(rs.getString("ticker"));
        result.setQuantity(rs.getLong("total_units"));
        result.setBasis(rs.getBigDecimal("total_basis"));

        return result;
    }
}
