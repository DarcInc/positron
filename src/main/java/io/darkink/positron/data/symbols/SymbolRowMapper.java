package io.darkink.positron.data.symbols;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SymbolRowMapper implements RowMapper<Symbol> {
    @Override
    public Symbol mapRow(ResultSet rs, int rowNum) throws SQLException {
        String ticker = rs.getString("ticker");
        String type = rs.getString("symbol_type");
        String exchange = rs.getString("exchange");

        return new Symbol(ticker, SymbolType.get(type).orElseThrow(), exchange);
    }
}
