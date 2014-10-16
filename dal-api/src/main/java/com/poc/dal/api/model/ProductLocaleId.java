package com.poc.dal.api.model;

import java.io.Serializable;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Id for Composite key - Product and ProductLocale
 */
@Embeddable
public class ProductLocaleId implements Serializable {

    private ProductDBO productDBO;
    private Locale locale;

    /**
     * Gets productDBO.
     *
     * @return Value of productDBO.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "productId", referencedColumnName = "productId")
    public ProductDBO getProductDBO() {
        return productDBO;
    }

    /**
     * Sets new productDBO.
     *
     * @param productDBO New value of productDBO.
     */
    public void setProductDBO(ProductDBO productDBO) {
        this.productDBO = productDBO;
    }

    /**
     * Sets new locale.
     *
     * @param locale New value of locale.
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Gets locale.
     *
     * @return Value of locale.
     */
    public Locale getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductLocaleId{");
        sb.append("productDBO=").append(productDBO);
        sb.append(", locale=").append(locale);
        sb.append('}');
        return sb.toString();
    }
}
