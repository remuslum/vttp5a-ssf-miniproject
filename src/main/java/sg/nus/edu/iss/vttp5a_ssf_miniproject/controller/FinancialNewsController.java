package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.model.NewsArticle;
import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.FinancialDataService;

@Controller
@RequestMapping("/news")
public class FinancialNewsController {
    @Autowired
    FinancialDataService financialDataService;
    
    @GetMapping
    public ModelAndView displayFinancialNews(){
        ModelAndView mav = new ModelAndView();
        List<NewsArticle> news = financialDataService.getLatestNewsArticles();
        NewsArticle latestNews = news.get(0);

        mav.addObject("newsArticles", news);
        mav.addObject("sample", latestNews);
        mav.setViewName("news");
        return mav;
    }
}
