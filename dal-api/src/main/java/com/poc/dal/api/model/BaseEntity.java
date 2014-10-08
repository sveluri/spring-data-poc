package com.poc.dal.api.model;

import java.io.Serializable;

/**
 * Base BaseEntity
 */
public interface BaseEntity extends Serializable, Comparable<BaseEntity> {

    Long getId();

    void setId(Long id);
}
