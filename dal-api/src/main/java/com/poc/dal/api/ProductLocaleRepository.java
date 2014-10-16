package com.poc.dal.api;

import com.poc.dal.api.model.ProductDBO;
import com.poc.dal.api.model.ProductLocaleDBO;
import com.poc.dal.api.model.ProductLocaleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * TODO :
 */
public interface ProductLocaleRepository extends JpaRepository<ProductLocaleDBO, ProductLocaleId>, JpaSpecificationExecutor,
        PagingAndSortingRepository<ProductLocaleDBO, ProductLocaleId>  {
}
