package pl.piotrbrodziak.zadaniepolitechnika.controller;

import org.springframework.web.bind.annotation.*;
import pl.piotrbrodziak.zadaniepolitechnika.HttpClient.CurrencyClient;
import pl.piotrbrodziak.zadaniepolitechnika.dto.CurrencyDto;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;
import pl.piotrbrodziak.zadaniepolitechnika.service.CurrencyService;
import pl.piotrbrodziak.zadaniepolitechnika.service.RatesService;

@RestController
@RequestMapping("currency")
@CrossOrigin("*")
public class CurrencyController {

    private final CurrencyClient currencyClient;
    private final RatesService ratesService;
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyClient currencyClient, RatesService ratesService, CurrencyService currencyService) {
        this.currencyClient = currencyClient;
        this.ratesService = ratesService;
        this.currencyService = currencyService;
    }

    @GetMapping("{currency}/{date1}/{date2}")
    public CurrencyDto getCurrency(@PathVariable String currency, @PathVariable String date1,@PathVariable String date2 ){
        Rates rates1 = currencyClient.getCurrencyOneFromURL(currency, date1);
        Rates rates2 = currencyClient.getCurrencyOneFromURL(currency, date2);
        CurrencyDto currencyDto = currencyService.designateCurrencyDto(rates1, rates2);
        return currencyDto;
    }


}
