package com.poc.dal.api.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.poc.dal.api.model.ProductDBO;

/**
 * Specifications used in queries
 */
public class ProductSpecifications {

    public static Specification<ProductDBO> isActive(final Boolean active) {
        Specification<ProductDBO> productDBOSpecification = null;

        productDBOSpecification = new Specification<ProductDBO>() {
            @Override
            public Predicate toPredicate(Root<ProductDBO> productDBORoot, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(productDBORoot.get("active"), active);
            }
        };
        return productDBOSpecification;
    }
}
