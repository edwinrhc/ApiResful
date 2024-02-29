package org.erhc.app.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.erhc.app.validation.IsExistsDb;
import org.erhc.app.validation.IsRequired;

@Entity
@Table(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired(message = "{IsRequired.product.name}")
    @Size(min = 2, max = 100, message = "Name must be between 3 and 100 characters")
    @Column(name = "name")
    private String name;

    @NotNull(message = "{NotNull.product.price}")
    @Min(value=500, message="{Min.product.price}")
    @Column(name="price")
    private Integer price;

    @Column(name="description")
    @IsRequired
    private String description;

    @IsRequired
    @IsExistsDb
    private String sku;


}
