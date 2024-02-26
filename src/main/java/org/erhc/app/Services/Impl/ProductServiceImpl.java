package org.erhc.app.Services.Impl;

import org.erhc.app.Entities.Product;
import org.erhc.app.Repositories.ProductRepository;
import org.erhc.app.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> delete(Product product) {

        Optional<Product> productOptional = productRepository.findById(product.getId());
        productOptional.ifPresent(productDB -> {
            productRepository.delete(productDB);
        });
        return productOptional;
    }
}
