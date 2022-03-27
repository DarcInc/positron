package io.darkink.positron.web;

import io.darkink.positron.data.positions.Position;
import io.darkink.positron.data.positions.PositionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path="/positions")
public class PositionsController {
    private final PositionRepository positionRepository;

    public PositionsController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(@ModelAttribute("model")ModelMap model) {
        List<Position> positions = positionRepository.allPositions();
        model.addAttribute("positions", positions);
        return "positions/index";
    }
}
