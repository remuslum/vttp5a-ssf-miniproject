package sg.nus.edu.iss.vttp5a_ssf_miniproject.controller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.edu.iss.vttp5a_ssf_miniproject.service.restservice.StockSymbolRestService;

@RestController
@RequestMapping("/symbols")
public class StockSymbolRestController {

    @Autowired
    StockSymbolRestService stockSymbolRestService;

    @GetMapping
    public ResponseEntity<String> getStockSymbols(){
        if(stockSymbolRestService.getStockSymbols()){
            return ResponseEntity.ok().body("Saved into Redis");
        } else {
            return ResponseEntity.badRequest().body("Unable to save into Redis");
        }
    }
}
