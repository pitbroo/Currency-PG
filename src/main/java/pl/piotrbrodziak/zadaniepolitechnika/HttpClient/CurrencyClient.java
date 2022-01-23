package pl.piotrbrodziak.zadaniepolitechnika.HttpClient;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;
import pl.piotrbrodziak.zadaniepolitechnika.service.RatesService;


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
        rates = ratesService.getRatesFromCurrentJsonNode(currencyJsonNode);
//        CurrencyDTO currencyDTO = new CurrencyDTO();
//        currencyDTO.setNo(currencyJsonNode.get(0).get("no").asText());
//        currencyDTO.setEffectiveDate(currencyJsonNode.get(0).get("effectiveDate").asText());
//        currencyDTO.setTable(currencyJsonNode.get(0).get("table").asText());
//        //Tutaj zmienić to, żeby nie było statyczne
//        currencyDTO.setRates(RatesService.getRatefromCurrentJsonNode(currencyJsonNode));
        return rates;
    }


}
