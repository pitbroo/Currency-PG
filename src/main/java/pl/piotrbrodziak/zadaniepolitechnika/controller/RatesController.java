package pl.piotrbrodziak.zadaniepolitechnika.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piotrbrodziak.zadaniepolitechnika.HttpClient.CurrencyClient;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rates")
@CrossOrigin("*")
public class RatesController {
    private final CurrencyClient currencyClient;

    public RatesController(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    @GetMapping
    public ResponseEntity<List<Rates>> getRatesList(){
        return ResponseEntity.ok(currencyClient.getRatesList());
    }
}
