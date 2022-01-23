package pl.piotrbrodziak.zadaniepolitechnika.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
public class Rates {
    String effectiveDate;
    String code;
    String currency;
    Double bid;
    Double ask;
}
