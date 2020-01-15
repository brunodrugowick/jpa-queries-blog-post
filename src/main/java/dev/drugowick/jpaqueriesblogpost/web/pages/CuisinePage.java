package dev.drugowick.jpaqueriesblogpost.web.pages;

import dev.drugowick.jpaqueriesblogpost.domain.model.Cuisine;
import dev.drugowick.jpaqueriesblogpost.infrastructure.repository.CuisineRepository;
import dev.drugowick.jpaqueriesblogpost.infrastructure.repository.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuisines")
public class CuisinePage {

    private final RestaurantRepository restaurantRepository;
    private final CuisineRepository cuisineRepository;


    public CuisinePage(RestaurantRepository restaurantRepository, CuisineRepository cuisineRepository) {
        this.restaurantRepository = restaurantRepository;
        this.cuisineRepository = cuisineRepository;
    }

    @RequestMapping("/{id}")
    public String index(@PathVariable("id") Long id, Model model) {
        Cuisine cuisine = cuisineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Could not find cuisine with id %d", id)
                ));
        model.addAttribute("cuisine", cuisine);
        model.addAttribute("count", restaurantRepository.countByCuisineName(cuisine.getName()));
        model.addAttribute("cheapestRestaurant", restaurantRepository.findTopByCuisineNameOrderByDeliveryFeeAsc(cuisine.getName()));
        return "cuisine";
    }
}