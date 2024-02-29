package org.erhc.app.Services;

import org.erhc.app.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    /**
     * A description of the entire Java function.
     *
     * @param  id       description of parameter
     * @param  product  description of parameter
     * @return         description of return value
     */
    Optional<Product> update(Long id, Product product);

     Optional<Product> delete(Long id);

    /**
     * A description of the entire Java function.
     *
     * @param  sku	description of parameter
     * @return      description of return value
     */
    boolean existsBySku(String sku);


}
