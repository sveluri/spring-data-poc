package com.poc.dal.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.poc.dal.api.model.CategoryDBO;

/**
 * Repository to manager Categories
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryDBO, Long>, JpaSpecificationExecutor,
                PagingAndSortingRepository<CategoryDBO, Long> {
}
