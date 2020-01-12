package dev.drugowick.jpaqueriesblogpost.web.pages;

import dev.drugowick.jpaqueriesblogpost.infrastructure.repository.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPage {

    private final RestaurantRepository restaurantRepository;

    public IndexPage(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("restaurants", restaurantRepository.findAll());
        return "index";
    }
}
