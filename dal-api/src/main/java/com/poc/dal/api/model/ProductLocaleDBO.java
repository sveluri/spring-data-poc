package com.poc.dal.api.model;

import javax.persistence.*;
import java.util.Locale;

/**
 * Product Locale entity
 */
@Entity(name = "product_locale")
@Table(name = "product_locale")
public class ProductLocaleDBO {

    @EmbeddedId
    private ProductLocaleId id;

    private String title;

    /**
     * Sets new title.
     *
     * @param title New value of title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets title.
     *
     * @return Value of title.
     */
    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductLocaleDBO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(ProductLocaleId id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public ProductLocaleId getId() {
        return id;
    }
}
