package dev.drugowick.jpaqueriesblogpost.web.pages;

import dev.drugowick.jpaqueriesblogpost.infrastructure.repository.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/search")
    public String indexWithQuery(@RequestParam("query") String query,
                                 @RequestParam("field") String field,
                                 Model model) {
        if (field.equals("name")) {
            model.addAttribute("restaurants", restaurantRepository.findAllByNameContaining(query));
        }
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        return "index";
    }
}
