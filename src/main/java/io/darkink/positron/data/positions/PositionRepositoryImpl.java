package io.darkink.positron.data.positions;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PositionRepositoryImpl implements PositionRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private PositionRowMapper positionRowMapper;

    private static final String ALL_POSITIONS = "SELECT ticker, total_units, total_basis " +
            "FROM position_rollups " +
            "ORDER BY ticker ASC";

    public PositionRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.positionRowMapper = new PositionRowMapper();
    }

    @Override
    public List<Position> allPositions() {
        List<Position> positions = jdbcTemplate.query(ALL_POSITIONS, this.positionRowMapper);
        return positions;
    }
}
