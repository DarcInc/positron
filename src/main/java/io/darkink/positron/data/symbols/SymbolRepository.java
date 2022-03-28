package io.darkink.positron.data.symbols;

import java.util.List;
import java.util.Optional;

public interface SymbolRepository {
    List<Symbol> allSymbols();
    Optional<Symbol> findByticker(String ticker);
}
