package com.example.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.repository.ProductRepository;
import com.example.test.model.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Boolean patch(Long id, Product product) {
        Optional<Product> existingProductOptional = this.getById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // 更新屬性
            if (product.getName() != null) {
                existingProduct.setName(product.getName());
            }

            if (product.getPrice() > 0) {
                existingProduct.setPrice(product.getPrice());
            }

            // 儲存更新後的產品
            // return productService.save(existingProduct);

            productRepository.save(existingProduct);
            return true;
        }

        return false;
    }

    public Boolean delete(Long id) {
        Optional<Product> existingProductOptional = this.getById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Soft Delete
            existingProduct.setUsenot(false);

            productRepository.save(existingProduct);
            return true;
        }

        return false;
    }
}
