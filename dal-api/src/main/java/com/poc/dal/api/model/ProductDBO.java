package com.poc.dal.api.model;

import javax.persistence.*;

/**
 * DBO for Product
 */
@Entity(name = "product")
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = { "product_id" }))
public class ProductDBO {
    private static final long serialVersionUID = 1L;


    private long id;
    private String name;
    private String description;
    private boolean active;


    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;

    }

    /**
     * Gets description.
     *
     * @return Value of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new description.
     *
     * @param description New value of description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @org.hibernate.annotations.GenericGenerator(name = "product_seq", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "product_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "50"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "none") })

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ProductDBO that = (ProductDBO) o;

        if (id != that.id)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDBO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", active=").append(active);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Gets active.
     *
     * @return Value of active.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets new active.
     *
     * @param active New value of active.
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
