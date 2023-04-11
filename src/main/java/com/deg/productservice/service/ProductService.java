package com.deg.productservice.service;

import com.deg.productservice.model.Product;
import com.deg.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Obtener todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Crear producto
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Actualizar producto
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        existingProduct.setDescription(product.getDescription());
        existingProduct.setCode(product.getCode());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }

    // Eliminar producto
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }

    // Buscar producto por código
    public List<Product> searchProductsByCode(String productCode) {
        return productRepository.findByCodeContaining(productCode);
    }

}
