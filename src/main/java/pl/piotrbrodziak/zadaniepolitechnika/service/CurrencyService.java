package pl.piotrbrodziak.zadaniepolitechnika.service;

import org.springframework.stereotype.Service;
import pl.piotrbrodziak.zadaniepolitechnika.dto.CurrencyDto;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;

@Service
public interface CurrencyService {
    CurrencyDto designateCurrencyDto(Rates rates1, Rates rates2);
}
