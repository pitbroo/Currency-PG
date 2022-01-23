package pl.piotrbrodziak.zadaniepolitechnika.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotrbrodziak.zadaniepolitechnika.HttpClient.CurrencyClient;
import pl.piotrbrodziak.zadaniepolitechnika.dto.CurrencyDto;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;
import pl.piotrbrodziak.zadaniepolitechnika.service.CurrencyService;

@RestController
@RequestMapping("currency")
@CrossOrigin("*")
public class CurrencyController {

    private final CurrencyClient currencyClient;
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyClient currencyClient, CurrencyService currencyService) {
        this.currencyClient = currencyClient;
        this.currencyService = currencyService;
    }

    @GetMapping("{currency}/{date1}/{date2}")
    public ResponseEntity<CurrencyDto> getCurrency(@PathVariable String currency, @PathVariable String date1, @PathVariable String date2) {
        Rates rates1 = currencyClient.getCurrencyOneFromURL(currency, date1);
        Rates rates2 = currencyClient.getCurrencyOneFromURL(currency, date2);
        return ResponseEntity.ok(currencyService.designateCurrencyDto(rates1, rates2));
    }

}
