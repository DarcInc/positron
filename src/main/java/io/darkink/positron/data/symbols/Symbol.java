package io.darkink.positron.data.symbols;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Symbol {
    private String ticker;
    private SymbolType symbolType;
    private String exchange;
}
