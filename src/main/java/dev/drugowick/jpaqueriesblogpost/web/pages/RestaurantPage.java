package dev.drugowick.jpaqueriesblogpost.web.pages;

import dev.drugowick.jpaqueriesblogpost.infrastructure.repository.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurants")
public class RestaurantPage {

    private final RestaurantRepository restaurantRepository;

    public RestaurantPage(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @RequestMapping("/{id}")
    public String index(@PathVariable("id") Long id, Model model) {
        model.addAttribute("restaurant", restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Could not find restaurant with id %d", id)
                )));
        return "restaurant";
    }
}
