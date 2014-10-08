package com.poc.dal.api.model;

/**
 * Abstract implementation for BaseEntity
 */
public abstract class AbstractBaseEntity implements BaseEntity {

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(BaseEntity other) {
        if (this == other)
            return 0; // same entity

        if (other == null)
            return 1; // nulls filter to the bottom

        if (getId() == null) {
            if (other.getId() != null)
                return -1;
            else
                return 0; // both ids are null
        } else if (other.getId() == null)
            return 1;
        else
            return getId().compareTo(other.getId());
    }
}
