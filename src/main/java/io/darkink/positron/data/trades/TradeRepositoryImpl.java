package io.darkink.positron.data.trades;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public class TradeRepositoryImpl implements TradeRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private TradeRowMapper tradeRowMapper;

    public static final String ALL_TRADES = "SELECT id, ticker, trans_type, event_date, recorded_on, units, price " +
            "FROM trades " +
            "ORDER BY ticker, event_date";

    public TradeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        tradeRowMapper = new TradeRowMapper();
    }

    @Override
    public List<Trade> allTrades() {
        List<Trade> allTrades = jdbcTemplate.query(ALL_TRADES, tradeRowMapper);

        return allTrades;
    }

    @Override
    public Trade save(String ticker, TransType transType, Date eventDate, Long units, BigDecimal price) {
        return null;
    }

}
