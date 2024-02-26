package org.erhc.app.Services;

import org.erhc.app.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

     Optional<Product> delete (Product product);
}
