package com.poc.dal.api.impl;

import com.poc.dal.api.ProductCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation for {@link com.poc.dal.api.ProductCustomRepository}
 */
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Sets new entityManager.
     *
     * @param entityManager New value of entityManager.
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
