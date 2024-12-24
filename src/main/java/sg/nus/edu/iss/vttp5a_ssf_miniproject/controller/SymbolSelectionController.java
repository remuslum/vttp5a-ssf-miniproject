package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.StockSymbol;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.StockSymbolService;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.RedisConstants;

@Controller
@RequestMapping("/picker")
public class SymbolSelectionController {
    
    @Autowired
    StockSymbolService stockSymbolService;

    @GetMapping
    public ModelAndView displayStockSymbolsInDropdown(){
        ModelAndView mav = new ModelAndView();
        List<StockSymbol> stockSymbols = stockSymbolService.getStockSymbolsFromRedis(RedisConstants.REDISKEY);
        mav.addObject("symbols", stockSymbols);
        mav.setViewName("stockpicker");
        return mav;

    }
}
