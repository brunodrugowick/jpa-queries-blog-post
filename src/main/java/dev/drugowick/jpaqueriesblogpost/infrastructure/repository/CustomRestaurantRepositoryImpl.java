package dev.drugowick.jpaqueriesblogpost.infrastructure.repository;

import dev.drugowick.jpaqueriesblogpost.domain.model.Restaurant;
import dev.drugowick.jpaqueriesblogpost.web.pages.dto.AdvancedSearch;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;

/**
 * This is a special class that Spring Data JPA (SDJ) detects and uses. This detection is based on the class name,
 * which is the name of the repository interface plus the string "Impl".
 */
@Repository
public class CustomRestaurantRepositoryImpl implements CustomRestaurantRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Restaurant> advancedSearch(AdvancedSearch advancedSearch) {

        var jpql = new StringBuilder();
        jpql.append("from Restaurant where 1=1 ");

        var parameters = new HashMap<String, Object>();
        var logicalOperator = advancedSearch.getLogicalOperator().equals("AND") ? "AND" : "OR";

        if (StringUtils.hasLength(advancedSearch.getName())) {
            jpql.append(logicalOperator + " name like :name ");
            parameters.put("name", "%" + advancedSearch.getName() + "%");
        }

        if (StringUtils.hasLength(advancedSearch.getAddress())) {
            jpql.append(logicalOperator + " address like :address ");
            parameters.put("address", "%" + advancedSearch.getAddress() + "%");
        }

        if (advancedSearch.getMinDeliveryFee() != null) {
            jpql.append(logicalOperator + " deliveryFee >= :startFee ");
            parameters.put("startFee", advancedSearch.getMinDeliveryFee());
        }

        if (advancedSearch.getMaxDeliveryFee() != null) {
            jpql.append(logicalOperator + " deliveryFee <= :endingFee ");
            parameters.put("endingFee", advancedSearch.getMaxDeliveryFee());
        }

        if (StringUtils.hasLength(advancedSearch.getCuisine())) {
            jpql.append(logicalOperator + " cuisine.name like :cuisine ");
            parameters.put("cuisine", "%" + advancedSearch.getCuisine() + "%");
        }

        if (StringUtils.hasLength(advancedSearch.getCity())) {
            jpql.append(logicalOperator + " city like :city ");
            parameters.put("city", "%" + advancedSearch.getCity() + "%");
        }

        TypedQuery<Restaurant> query = entityManager.createQuery(jpql.toString(), Restaurant.class);

        parameters.forEach((key, value) -> query.setParameter(key, value));

        return query.getResultList();
    }
}
