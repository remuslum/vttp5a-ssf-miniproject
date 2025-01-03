package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.StockSymbol;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.User;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.StockSymbolService;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.RedisConstants;

@Controller
@RequestMapping("/picker")
public class SymbolSelectionController {
    
    @Autowired
    StockSymbolService stockSymbolService;

    @GetMapping
    public ModelAndView displayStockSymbolsInDropdown(HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Optional<User> user = Optional.ofNullable((User)httpSession.getAttribute("user"));
        user.ifPresentOrElse((value) -> {
            List<StockSymbol> stockSymbols = stockSymbolService.getStockSymbolsFromRedis(RedisConstants.REDISKEY);
            mav.addObject("symbols", stockSymbols);
            mav.setViewName("stockpicker");
            }, 
            () -> {
                mav.setViewName("error");
            });
        
        return mav;

    }

    @PostMapping
    public String getCompanySymbol(@RequestParam(name = "stockSymbol", defaultValue = "") String stockSymbol, Model model){
        if(stockSymbol.isEmpty()){
            List<StockSymbol> stockSymbols = stockSymbolService.getStockSymbolsFromRedis(RedisConstants.REDISKEY);
            model.addAttribute("symbols", stockSymbols);
            model.addAttribute("errorMessage", "Please select a stock symbol");
            return "stockpicker";
        }
        return "redirect:/company/" + stockSymbol;

    }
}
