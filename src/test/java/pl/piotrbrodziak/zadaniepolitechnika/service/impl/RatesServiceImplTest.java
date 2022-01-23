package pl.piotrbrodziak.zadaniepolitechnika.service.impl;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pl.piotrbrodziak.zadaniepolitechnika.dto.Rates;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RatesServiceImplTest {
    RatesServiceImpl ratesService;
    Rates rates1;
    Rates rates2;

    @BeforeAll
    void setUp(){
        ratesService = new RatesServiceImpl();
        rates1 = new Rates();
        rates2 = new Rates();

        rates1.setCurrency("dolar amerykański");
        rates1.setEffectiveDate("2021-02-03");
        rates1.setCode("USD");
        rates1.setAsk(3.686);
        rates1.setBid(4.9999);

        rates2.setCurrency("dolar amerykański");
        rates2.setEffectiveDate("2021-02-02");
        rates2.setCode("USD");
        rates2.setAsk(3.6733);
        rates2.setBid(3.9999);
    }

    @Test
    void should1getSumAskTest() {
        Assertions.assertEquals(ratesService.getSumAsk(rates1, rates2), 0.0127D);
    }
    @org.junit.jupiter.api.Test
    void should1getSumBidTest() {
        Assertions.assertEquals(ratesService.getSumBid(rates1, rates2), 1.00D);
    }

}