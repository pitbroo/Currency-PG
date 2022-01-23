package pl.piotrbrodziak.zadaniepolitechnika.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;
import pl.piotrbrodziak.zadaniepolitechnika.service.RatesService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RatesServiceImpl implements RatesService {
    public static List<Rates> getRatesListfromCurrentJsonNode(JsonNode currencyJsonNode) {
        List<Rates> ratesList = new ArrayList<>();
        for (JsonNode rate : currencyJsonNode.get(0).get("rates")) {
            Rates r = new Rates();
            r.setCurrency(rate.get("currency").asText());
            r.setCode(rate.get("code").asText());
            //r.setBid(rate.get("mid").asDouble());
            ratesList.add(r);
        }
        return ratesList;
    }

    @Override
    public Rates getRatesFromCurrentJsonNode(JsonNode currencyJsonNode){
        Rates rates = new Rates();
        rates.setCurrency(currencyJsonNode.get("currency").asText());
        rates.setEffectiveDate(currencyJsonNode.get("rates").get(0).get("effectiveDate").asText());
        rates.setCode(currencyJsonNode.get("code").asText());
        rates.setBid(currencyJsonNode.get("rates").get(0).get("bid").asDouble());
        rates.setAsk(currencyJsonNode.get("rates").get(0).get("ask").asDouble());
        return rates;
    }
    @Override
    public List<Rates> getRatesListFromCurrentJsonNode(JsonNode currencyJsonNode){
        List<Rates> ratesList = new ArrayList<>();
        for (JsonNode jn: currencyJsonNode.get(0).get("rates")) {
            ratesList.add(getRatesFromCurrentJsonNodeWithoutDate(jn));
        }
        return ratesList;
    }

    @Override
    public Double getSumAsk(Rates rates1, Rates rates2) {
        BigDecimal sum;
        BigDecimal ratesA = BigDecimal.valueOf(rates1.getAsk());
        BigDecimal ratesB = BigDecimal.valueOf(rates2.getAsk());
        if (ratesA != null && ratesB!= null) {
            if (rates1.getAsk() > rates2.getAsk() ){
                sum = ratesA.subtract(ratesB);
            } else sum = ratesB.subtract(ratesA);
        } else sum = new BigDecimal(0.00d);
        return sum.doubleValue();
    }

    @Override
    public Double getSumBid(Rates rates1, Rates rates2) {
        BigDecimal sum;
        BigDecimal ratesA = BigDecimal.valueOf(rates1.getBid());
        BigDecimal ratesB = BigDecimal.valueOf(rates2.getBid());
        if (ratesA != null && ratesB!= null) {
            if (rates1.getBid() > rates2.getBid() ){
                sum = ratesA.subtract(ratesB);
            } else sum = ratesB.subtract(ratesA);
        } else sum = new BigDecimal(0.00d);
        return sum.doubleValue();
    }
    public Rates getRatesFromCurrentJsonNodeWithoutDate(JsonNode currencyJsonNode){
        Rates rates = new Rates();
        rates.setCurrency(currencyJsonNode.get("currency").asText());
        rates.setCode(currencyJsonNode.get("code").asText());
        rates.setBid(currencyJsonNode.get("bid").asDouble());
        rates.setAsk(currencyJsonNode.get("ask").asDouble());
        return rates;
    }
}
