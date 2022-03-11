package ru.pcs.example.javashop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcs.example.javashop.forms.ProductForm;
import ru.pcs.example.javashop.models.Product;
import ru.pcs.example.javashop.repositories.ProductRepository;


import java.util.List;

@Component
public class ProductsServiceImpl implements ProductsService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(ProductForm form) {
        Product product = Product.builder()
                .name(form.getName())
                .cost(form.getCost())
                .amount(form.getAmount())
                .build();
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Integer productId, ProductForm form) {
        Product product = Product.builder()
                .id(productId)
                .name(form.getName())
                .cost(form.getCost())
                .amount(form.getAmount())
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Integer productId) {
        return productRepository.getById(productId);
    }
}

