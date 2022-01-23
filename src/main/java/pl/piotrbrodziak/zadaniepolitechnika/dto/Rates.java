package pl.piotrbrodziak.zadaniepolitechnika.dto;

import lombok.Data;


@Data
public class Rates {
    String effectiveDate;
    String code;
    String currency;
    double bid;
    double ask;
}
