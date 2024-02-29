package org.erhc.app.Repositories;

import org.erhc.app.Entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product,Long> {

    boolean existsBySku(String sku);

}
