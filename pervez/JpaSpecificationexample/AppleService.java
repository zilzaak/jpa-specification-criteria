package com.hrms.pervez.JpaSpecificationexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class AppleService {

    @Autowired
    private AppleRepository appleRepository;

    private static Specification<Apple> getApplesByName(String appleName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("applename"), appleName);
    }

    private static Specification<Apple> getApplesByTasteIn(List<String> taste) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get("taste")).value(taste);
    }

    private static Specification<Apple> getPricesInBetween(float minPrice, float maxPrice) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
    }

    private static Specification<Apple> getApplesNameLike(String appleName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("appleName"), "%" + appleName + "%");
    }

    public List<Apple> getAllSpecification(String appleName, List<String> taste, float minPrice, float maxPrice) {
        return appleRepository.findAll(
                where(getApplesByName(appleName)).
                and(getApplesByTasteIn(taste)).
                and(getPricesInBetween(minPrice, maxPrice)).
                and(getApplesNameLike(appleName)));
    }


    public List<Apple> getAppleNameLike(String appleName) {
        return appleRepository.findAll(
                where(getApplesNameLike(appleName)));
    }

    public List<Apple> getApplepricebetween(float price1,float price2) {
        return appleRepository.findAll(
                where(getPricesInBetween(price1,price2)));
    }

}