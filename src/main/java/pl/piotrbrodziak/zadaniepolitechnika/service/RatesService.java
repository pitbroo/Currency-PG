package pl.piotrbrodziak.zadaniepolitechnika.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;

@Service
public interface RatesService {
    Rates getRatesFromCurrentJsonNode(JsonNode currencyJsonNode);
    Double getSumAsk(Rates rates1,Rates rates2);
    Double getSumBid(Rates rates1,Rates rates2);
}
