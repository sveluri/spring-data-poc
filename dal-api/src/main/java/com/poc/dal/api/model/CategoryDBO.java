package com.poc.dal.api.model;

import javax.persistence.*;
import java.util.List;

/**
 * Category Information
 */
@Entity(name = "category")
@Table(name = "category", uniqueConstraints = @UniqueConstraint(columnNames = { "category_id" }))
public class CategoryDBO extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private List<ProductDBO> productDBOList;

    @Override
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @org.hibernate.annotations.GenericGenerator(name = "category_seq", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "category_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "50"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "none") })
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
     * Gets productDBOList.
     *
     * @return Value of productDBOList.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public List<ProductDBO> getProductDBOList() {
        return productDBOList;
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
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
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
     * Sets new productDBOList.
     *
     * @param productDBOList New value of productDBOList.
     */
    public void setProductDBOList(List<ProductDBO> productDBOList) {
        this.productDBOList = productDBOList;
    }

    public void addProduct(ProductDBO productDBO) {
        productDBOList.add(productDBO);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CategoryDBO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
