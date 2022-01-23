package pl.piotrbrodziak.zadaniepolitechnika.service.impl;

import org.springframework.stereotype.Service;
import pl.piotrbrodziak.zadaniepolitechnika.dto.CurrencyDto;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;
import pl.piotrbrodziak.zadaniepolitechnika.service.CurrencyService;
import pl.piotrbrodziak.zadaniepolitechnika.service.RatesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    public final RatesService ratesService;

    public CurrencyServiceImpl(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @Override
    public CurrencyDto designateCurrencyDto(Rates rates1, Rates rates2) {
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setSumAsk(ratesService.getSumAsk(rates1, rates2));
        currencyDto.setSumBid(ratesService.getSumBid(rates1, rates2));
        List<Rates> ratesList = new ArrayList<>();
        ratesList.add(rates1);
        ratesList.add(rates2);
        currencyDto.setRates(ratesList);
        return currencyDto;
    }
}
