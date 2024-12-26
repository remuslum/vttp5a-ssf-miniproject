package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.CompanyFinancials;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.NewsArticle;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.StockSymbol;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.CompanyNewsService;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.StockSymbolService;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.restservice.CompanyFinancialsService;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.util.RedisConstants;

@Controller
@RequestMapping("/company")
public class CompanyNewsController {
    @Autowired
    CompanyNewsService companyNewsService;

    @Autowired
    CompanyFinancialsService companyFinancialsService;

    @Autowired
    StockSymbolService stockSymbolService;
    
    @GetMapping("/{company-symbol}")
    public ModelAndView getCompanyNews(@PathVariable("company-symbol") String companySymbol){
        ModelAndView mav = new ModelAndView();
        List<NewsArticle> companyNews = companyNewsService.getCompanyNews(companySymbol);
        CompanyFinancials companyFinancials = companyFinancialsService.getCompanyFinancials(companySymbol);

        StockSymbol currentCompany = stockSymbolService.getStockSymbolsFromRedis(RedisConstants.REDISKEY).stream()
        .filter(s -> s.getSymbol().equals(companySymbol)).findFirst().get();
        
        mav.addObject("company",currentCompany);
        mav.addObject("companyName", companySymbol);
        mav.addObject("companyFinancials", companyFinancials);
        mav.addObject("newsArticles", companyNews);

        mav.setViewName("companynews");
        
        return mav;
    }

    @GetMapping("/bar")
    public String barChart(Model model) throws JsonProcessingException{
        CompanyFinancials companyFinancials = companyFinancialsService.getCompanyFinancials("AAPL");
        Map<String, Double> currentRatio = companyFinancials.getCurrentRatio();

        List<Map.Entry<String, Double>> sortedEntries = currentRatio.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())  // Sort by the String key
            .collect(Collectors.toList());

        // Rebuild a new LinkedHashMap to maintain the order
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : sortedEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        List<String> period = new ArrayList<>(sortedMap.keySet());
        List<Double> ratio = new ArrayList<>(sortedMap.values());

        ObjectMapper mapper = new ObjectMapper();
        String periodJson = mapper.writeValueAsString(period);
        String ratioJson = mapper.writeValueAsString(ratio);

        model.addAttribute("period", periodJson);
        model.addAttribute("ratio",ratioJson);

        return "barchart";
    }

    
}
