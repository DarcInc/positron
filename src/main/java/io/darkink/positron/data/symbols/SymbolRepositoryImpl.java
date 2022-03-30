package io.darkink.positron.data.symbols;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class SymbolRepositoryImpl implements SymbolRepository {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Symbol> rowMapper;

    public static final String ALL_SYMBOLS_QUERY = "SELECT ticker, symbol_type, exchange FROM symbols " +
            "ORDER BY symbol_type, ticker";

    public static final String FIND_BY_TICKER_QUERY = "SELECT ticker, symbol_type, exchange FROM symbols " +
            "WHERE ticker = ?";

    public SymbolRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        rowMapper = new SymbolRowMapper();
    }

    @Override
    public List<Symbol> allSymbols() {
        List<Symbol> allSymbols = jdbcTemplate.query(ALL_SYMBOLS_QUERY, rowMapper);
        return allSymbols;
    }

    @Override
    public Optional<Symbol> findByticker(String ticker) {
        List<Symbol> symbol = jdbcTemplate.query(FIND_BY_TICKER_QUERY, rowMapper, ticker);
        if (symbol.size() > 0) {
            return Optional.of(symbol.get(0));
        }
        return Optional.empty();
    }
}
