package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.NewsArticle;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.CompanyNewsService;

@Controller
@RequestMapping("/company")
public class CompanyNewsController {
    @Autowired
    CompanyNewsService companyNewsService;
    
    @GetMapping("/{company-symbol}")
    public ModelAndView getCompanyNews(@PathVariable("company-symbol") String companySymbol){
        ModelAndView mav = new ModelAndView();
        List<NewsArticle> companyNews = companyNewsService.getCompanyNews(companySymbol);

        mav.addObject("newsArticles", companyNews);
        mav.setViewName("companynews");
        return mav;
    }

    @PostMapping
    public String getCompanySymbol(@RequestParam("stockSymbol") String stockSymbol){
        return "redirect:/company/" + stockSymbol;

    }
}
