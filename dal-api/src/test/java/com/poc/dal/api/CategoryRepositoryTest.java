package com.poc.dal.api;

import com.poc.dal.api.model.CategoryDBO;
import com.poc.dal.api.model.ProductDBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Integration test for {@link com.poc.dal.api.CategoryRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-database-beans.xml")
@Transactional
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void test_FindAll() {

        // fires three queries

        List<CategoryDBO> all = categoryRepository.findAll();
        System.out.println(all);
    }

}
