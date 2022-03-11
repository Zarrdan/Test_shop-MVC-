package ru.pcs.example.javashop.services;

import ru.pcs.example.javashop.forms.ProductForm;
import ru.pcs.example.javashop.models.Product;


import java.util.List;

public interface ProductsService {
    Product addProduct(ProductForm form);

    List<Product> getAllProducts();

    void deleteProduct(Integer productId);

    Product updateProduct(Integer productId, ProductForm form);

    Product getProduct(Integer productId);
}

