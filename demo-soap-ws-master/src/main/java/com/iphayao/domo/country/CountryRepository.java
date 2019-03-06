package com.iphayao.domo.country;

import com.iphayao.producing_web_service.Country;
import com.iphayao.producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);
        
        Country jp = new Country();
        jp.setName("Japan");
        jp.setCapital("Tokyo");
        jp.setCurrency(Currency.JPY);
        jp.setPopulation(6370000);

        countries.put(spain.getName(), spain);
        countries.put(poland.getName(), poland);
        countries.put(uk.getName(), uk);
        countries.put(jp.getName(), jp);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }
}
