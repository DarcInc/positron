package io.darkink.positron.web;

import io.darkink.positron.data.trades.Trade;
import io.darkink.positron.data.trades.TradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/trades")
public class TradesController {
    private TradeRepository tradeRepository;
    private Logger logger = LoggerFactory.getLogger(TradesController.class);

    public TradesController(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String index(ModelMap model) {
        List<Trade> allTrades = tradeRepository.allTrades();
        model.addAttribute("trades", allTrades);

        return "trades/index";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create(@ModelAttribute NewTradeForm newTradeForm, Model model) {
        logger.info("Creating new trade %s %s %d %f".formatted(newTradeForm.getTicker(), newTradeForm.getTransType(),
                newTradeForm.getUnits(), newTradeForm.getPrice()));

        return "trades/new";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newTrade(@ModelAttribute("model")ModelMap model) {
        return "trades/new";
    }
}
