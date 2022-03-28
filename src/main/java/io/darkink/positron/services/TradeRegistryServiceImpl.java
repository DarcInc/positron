package io.darkink.positron.services;

import io.darkink.positron.data.positions.PositionRepository;
import io.darkink.positron.data.symbols.SymbolRepository;
import io.darkink.positron.data.trades.TradeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TradeRegistryServiceImpl implements TradeRegistryService {
    private TradeRepository tradeRepository;
    private PositionRepository positionRepository;
    private SymbolRepository symbolRepository;

    public TradeRegistryServiceImpl(TradeRepository tradeRepository, PositionRepository positionRepository,
                                    SymbolRepository symbolRepository) {
        this.tradeRepository = tradeRepository;
        this.positionRepository = positionRepository;
        this.symbolRepository = symbolRepository;
    }

    @Override
    public TradeDetails registerSale(String ticker, Long quantity, BigDecimal price) {
        return null;
    }

    @Override
    public TradeDetails registerPurchase(String ticker, Long quantity, BigDecimal price) {
        return null;
    }
}
