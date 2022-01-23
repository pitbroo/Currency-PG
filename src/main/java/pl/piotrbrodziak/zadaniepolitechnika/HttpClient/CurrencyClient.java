package pl.piotrbrodziak.zadaniepolitechnika.HttpClient;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;
import pl.piotrbrodziak.zadaniepolitechnika.service.RatesService;

import java.util.List;


@Component
public class CurrencyClient {
    private final RatesService ratesService;

    private static RestTemplate restTemplate = new RestTemplate();


    public CurrencyClient(RatesService ratesService) {
        this.ratesService = ratesService;
    }



    public Rates getCurrencyOneFromURL(String currency, String date){
        String URL = "https://api.nbp.pl/api/exchangerates/rates/c/"+currency+"/"+date+"/?format=json";
        JsonNode currencyJsonNode = restTemplate.getForObject(URL,JsonNode.class);
        Rates rates;
        return ratesService.getRatesFromCurrentJsonNode(currencyJsonNode);
    }
    public List<Rates> getRatesList(){
        String urlAll = "https://api.nbp.pl/api/exchangerates/tables/C?format=json";
        JsonNode currencyJsonNode = restTemplate.getForObject(urlAll, JsonNode.class);
        return ratesService.getRatesListFromCurrentJsonNode(currencyJsonNode);
    }


}
