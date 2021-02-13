package com.smarthost.challenge.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Configuration
public class CommonConfiguration {

    @Bean
    public List<Integer> getBids(){
        final List<Integer> bids = Arrays.asList(new Integer[]{23, 45, 155, 374, 22, 99, 100, 101, 115, 209});
        bids.sort(Comparator.comparingInt(b -> -b));
        return bids;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
