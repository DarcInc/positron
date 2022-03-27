package io.darkink.positron.data.trades;


import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TradeRowMapper implements RowMapper<Trade> {

    @Override
    public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trade result = new Trade();

        String id = rs.getString("id");
        result.setId(new BigInteger(id));
        result.setTicker(rs.getString("ticker"));

        String transType = rs.getString("trans_type");
        if (transType.equals("B")) {
            result.setTransType(TransType.Buy);
        } else {
            result.setTransType(TransType.Sell);
        }

        result.setEventDate(rs.getDate("event_date"));
        result.setRecordedOn(rs.getDate("recorded_on"));

        String units = rs.getString("units");
        result.setUnits(new BigInteger(units));

        result.setPrice(rs.getBigDecimal("price"));

        return result;
    }
}
