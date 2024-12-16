package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.NewsArticle;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.FinancialDataService;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.StockSymbolService;

@Controller
@RequestMapping
public class FinancialNewsController {
    @Autowired
    FinancialDataService financialDataService;

    @Autowired
    StockSymbolService stockSymbolService;
    
    @GetMapping
    public ModelAndView displayFinancialNews(){
        ModelAndView mav = new ModelAndView();
        List<NewsArticle> news = financialDataService.getNewsArticleList();
        List<String> symbols = stockSymbolService.getStockSymbols("US");

        mav.addObject("newsArticles", news);
        mav.addObject("symbols",symbols);
        mav.setViewName("news");
        return mav;
    }
}
