package pl.piotrbrodziak.zadaniepolitechnika.dto;

import lombok.Data;
import java.util.List;

@Data
public class CurrencyDto {
    public double sumAsk;
    public double sumBid;
    public List<Rates> rates;
}
