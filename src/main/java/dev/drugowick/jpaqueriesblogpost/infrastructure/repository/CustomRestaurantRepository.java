package dev.drugowick.jpaqueriesblogpost.infrastructure.repository;

import dev.drugowick.jpaqueriesblogpost.domain.model.Restaurant;
import dev.drugowick.jpaqueriesblogpost.web.pages.dto.AdvancedSearch;

import java.util.List;

public interface CustomRestaurantRepository {

    List<Restaurant> advancedSearch(AdvancedSearch advancedSearch);
}
