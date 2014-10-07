package com.poc.dal.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.dal.api.model.ProductDBO;

/**
 * Repository to for {@link com.poc.dal.api.model.ProductDBO}
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductDBO, Long> {

    ProductDBO findByName(String name);

    ProductDBO findByNameAndDescription(String name, String description);

    ProductDBO findByNameAndActive(String name, boolean active);

    List<ProductDBO> findByActive(boolean active);

}
