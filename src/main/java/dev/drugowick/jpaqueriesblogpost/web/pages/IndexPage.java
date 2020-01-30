package dev.drugowick.jpaqueriesblogpost.web.pages;

import dev.drugowick.jpaqueriesblogpost.infrastructure.repository.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

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
        } else if (field.equals("cuisine")) {
            model.addAttribute("restaurants", restaurantRepository.findAllByCuisineNameContaining(query));
        } else if (field.equals("delivery-fee")) {
            BigDecimal deliveryFee;
            try {
                deliveryFee = new BigDecimal(query);
            } catch (NumberFormatException e) {
                deliveryFee = new BigDecimal(100.00);
                query = "100.00";
            }
            model.addAttribute("restaurants", restaurantRepository.findAllByDeliveryFeeIsLessThanEqual(deliveryFee));
        } else if (field.equals("local-grabngo")) {
            model.addAttribute("restaurants", restaurantRepository.activeGrabngoByCity(query));
        }
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        return "index";
    }
}
