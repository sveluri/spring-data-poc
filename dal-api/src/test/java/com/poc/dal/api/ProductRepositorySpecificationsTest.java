package com.poc.dal.api;

import com.poc.dal.api.spec.ProductSpecifications;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Test for {@link com.poc.dal.api.ProductRepository} using Specifications
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-database-beans.xml")
@Transactional
public class ProductRepositorySpecificationsTest {


    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSpecification_isActive_True() {
        List all = productRepository.findAll(ProductSpecifications.isActive(Boolean.TRUE));
        System.out.println(all);
    }

    @Test
    public void testSpecification_isActive_False() {
        List all = productRepository.findAll(ProductSpecifications.isActive(Boolean.FALSE));
        System.out.println(all);
    }
}
