package io.darkink.positron.data.symbols;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class SymbolRepositoryImpl implements SymbolRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Symbol> rowMapper;

    private static final String ALL_SYMBOLS_QUERY = "SELECT ticker, symbol_type, exchange FROM symbols " +
            "ORDER BY symbol_type, ticker";

    private static final String FIND_BY_TICKER_QUERY = "SELECT ticker, symbol_type, exchange FROM symbols " +
            "WHERE ticker = ?";

    public SymbolRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        rowMapper = ((rs, rowNum) -> new Symbol(
                rs.getString("ticker"),
                SymbolType.get(rs.getString("symbol_type")).orElseThrow(),
                rs.getString("exchange")));
    }

    @Override
    public List<Symbol> allSymbols() {
        List<Symbol> allSymbols = jdbcTemplate.query(ALL_SYMBOLS_QUERY, rowMapper);
        return allSymbols;
    }

    @Override
    public Optional<Symbol> findByticker(String ticker) {
        List<Symbol> symbol = jdbcTemplate.query(FIND_BY_TICKER_QUERY, rowMapper);
        if (symbol.size() > 0) {
            return Optional.of(symbol.get(0));
        }
        return Optional.empty();
    }
}
