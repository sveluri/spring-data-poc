package com.poc.dal.api;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.jpa.impl.JPAQuery;
import com.poc.dal.api.model.ProductDBO;
import com.poc.dal.api.model.QProductDBO;
import com.poc.dal.api.spec.ProductSpecifications;

/**
 * Test for {@link com.poc.dal.api.ProductRepository} using QueryDsl
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-database-beans.xml")
@Transactional
public class ProductRepositoryQueryDslTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    private JPAQuery jpaQuery;

    @Before
    public void setUp() {
        jpaQuery = new JPAQuery(entityManager);
    }

    @Test
    public void test_FindByActive() {

        QProductDBO qProductDBO = QProductDBO.productDBO;
        List<ProductDBO> product = jpaQuery.from(qProductDBO).where(qProductDBO.active.eq(Boolean.TRUE))
            .list(qProductDBO);
        System.out.println(product);
    }

    @Test
    public void test_FindByAllProps() {

        QProductDBO qProductDBO = QProductDBO.productDBO;

        List<ProductDBO> product = jpaQuery.from(qProductDBO)
            .where(qProductDBO.active.eq(Boolean.TRUE), qProductDBO.name.eq("product1"))
            .list(qProductDBO);
        System.out.println(product);
    }

    @Test
    public void test_FindByAllProps_SortByName_QueryDsl() {

        QProductDBO qProductDBO = QProductDBO.productDBO;

        List<ProductDBO> product = jpaQuery.from(qProductDBO)
            .where(qProductDBO.active.eq(Boolean.TRUE))
            .orderBy(qProductDBO.name.asc())
            .list(qProductDBO);
        System.out.println(product);
    }

    @Test
    public void test_FindByAllProps_Pagination_SortByName_QueryDsl() {

        QProductDBO qProductDBO = QProductDBO.productDBO;

        // offset starts from 0 -> page number
        // limit -> page size

        List<ProductDBO> product = jpaQuery.from(qProductDBO)
            .where(qProductDBO.active.eq(Boolean.TRUE))
            .orderBy(qProductDBO.name.asc())
            .offset(0).limit(3)
            .list(qProductDBO);
        System.out.println(product);
    }

    @Test
    public void test_FindByAllProps_Pagination() {

        Pageable pageSpecification = new PageRequest(1, 1, null);

        Page<ProductDBO> all = productRepository.findAll(ProductSpecifications.isActive(true), pageSpecification);

        System.out.println(all.getContent());
    }

    @Test
    public void test_FindByAllProps_Pagination_Sorting() {

        // page specification -> page number, page size.
        // first page is 0 page

        Sort orders = new Sort(Sort.Direction.ASC, "name");
        Pageable pageSpecification = new PageRequest(0, 5, orders);

        Page<ProductDBO> all = productRepository.findAll(ProductSpecifications.isActive(true), pageSpecification);

        System.out.println(all.getContent());
        System.out.println("Total elements --> " + all.getTotalElements());
    }
}
