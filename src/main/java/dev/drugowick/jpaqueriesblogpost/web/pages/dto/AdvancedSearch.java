package dev.drugowick.jpaqueriesblogpost.web.pages.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class AdvancedSearch {
    private String name;
    private String address;
    private BigDecimal minDeliveryFee = new BigDecimal(0);
    private BigDecimal maxDeliveryFee = new BigDecimal(100);
    private String cuisine;
    private String city;
    private String grabngo;
    private String active;

    private String logicalOperator = "AND";
}
