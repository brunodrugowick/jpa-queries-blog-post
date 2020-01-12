package dev.drugowick.jpaqueriesblogpost;

import dev.drugowick.jpaqueriesblogpost.domain.model.Cuisine;
import dev.drugowick.jpaqueriesblogpost.domain.model.Restaurant;
import dev.drugowick.jpaqueriesblogpost.infrastructure.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaQueriesBlogPostApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaQueriesBlogPostApplication.class, args);
    }
}
