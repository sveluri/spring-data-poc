package com.poc.dal.api;

import java.util.List;
import java.util.Locale;

import com.poc.dal.api.model.CategoryDBO;
import com.poc.dal.api.model.ProductLocaleDBO;
import com.poc.dal.api.model.ProductLocaleId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.poc.dal.api.model.ProductDBO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-database-beans.xml")
@Transactional
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

     @Autowired
    private ProductLocaleRepository productLocaleRepository;

    @Test
    public void test_FindAll() {

        ProductDBO productDBO = new ProductDBO();
        productDBO.setName("product3");

        CategoryDBO one = categoryRepository.findOne(1L);
        productDBO.setCategoryDBO(one);
        one.addProduct(productDBO);

        ProductLocaleDBO productLocaleDBO = new ProductLocaleDBO();

        ProductLocaleId productLocaleId = new ProductLocaleId() ;
        productLocaleId.setLocale(Locale.US);
        productLocaleId.setProductDBO(productDBO);

        productLocaleDBO.setId(productLocaleId);
        productLocaleDBO.setTitle("titleee");
        productDBO.addProductLocale(productLocaleDBO);

        productRepository.save(productDBO);
        //productLocaleRepository.save(productLocaleDBO);

        List<ProductDBO> all = productRepository.findAll();
        System.out.println(all);

        ProductDBO productDBO1 = productRepository.findOne(50L);
        System.out.println(productDBO1.getProductLocaleDBOList());
    }

    @Test
    public void test_FindByName() {
        ProductDBO product = productRepository.findByName("product1");
        System.out.println(product);
    }

    @Test
    public void test_FindByName_NotExisting() {
        ProductDBO product = productRepository.findByName("product12");
        System.out.println(product);
    }

    @Test
    public void test_FindByNameAndDescription() {
        ProductDBO product = productRepository.findByNameAndDescription("product1", "product 1 description");
        System.out.println(product);
    }

    @Test
    public void test_FindByActive() {
        List<ProductDBO> products = productRepository.findByActive(true);
        System.out.println(products);
    }

    @Test
    public void test_FindByActive_False() {
        List<ProductDBO> products = productRepository.findByActive(false);
        System.out.println(products);
    }

    @Test
        public void test_FindCategory_FromProduct() {
        // Fires three queries
        ProductDBO product = productRepository.findByName("product1");
        System.out.println(product.getCategoryDBO());
    }

}
