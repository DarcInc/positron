package io.darkink.positron.data.symbols;

import java.util.Arrays;
import java.util.Optional;

public enum SymbolType {
    FUND("fund"),
    ETF("etf"),
    EQUITY("equity"),
    BOND("bond"),
    INDEX("index");

    private final String text;

    SymbolType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static Optional<SymbolType> get(String raw) {
        return Arrays.stream(SymbolType.values())
                .filter(st -> st.toString().equals(raw))
                .findFirst();
    }
}
