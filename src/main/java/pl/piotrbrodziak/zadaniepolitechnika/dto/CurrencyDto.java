package pl.piotrbrodziak.zadaniepolitechnika.dto;

import lombok.Data;

import java.util.List;

@Data
public class CurrencyDto {
    public Double sumAsk;
    public Double sumBid;
    public List<Rates> rates;
}
