package ru.pcs.example.javashop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pcs.example.javashop.JavashopApplicationTests;
import ru.pcs.example.javashop.forms.ProductForm;
import ru.pcs.example.javashop.models.Product;
import ru.pcs.example.javashop.services.ProductsServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductsServiceImplTest extends JavashopApplicationTests {
    @Autowired
    private ProductsServiceImpl productsService;
    ProductForm productForm = ProductForm.builder()
            .name("Macbook")
            .cost(10000)
            .amount(1)
            .build();

    @Test
    void testGetALLProducts() {
        List<Product> products = productsService.getAllProducts();
        assertNotNull(products);
    }

    @Test
    void testDeleteProduct() {
        Product createdProduct = productsService.addProduct(productForm);
        productsService.deleteProduct(createdProduct.getId());
    }

    @Test
    void testUpdateProduct() {
        ProductForm productFormUpdate = ProductForm.builder()
                .name("Macbookpro")
                .cost(150000)
                .amount(2)
                .build();
        Product oldProduct = productsService.addProduct(productForm);
        Product newProduct = productsService.updateProduct(oldProduct.getId(), productFormUpdate);
        assertEquals(oldProduct.getId(), newProduct.getId(), "Ids shouldn't be changed during the update");
        assertNotEquals(oldProduct.getName(), newProduct.getName());
        assertNotEquals(oldProduct.getCost(), newProduct.getCost());
        assertNotEquals(oldProduct.getAmount(), newProduct.getAmount());
    }

    @Test
    void TestgetProduct() {

        Product newproduct = productsService.addProduct(productForm);
        Product product = productsService.getProduct(newproduct.getId());
        assertEquals(product.getName(), newproduct.getName());
        assertEquals(product.getCost(), newproduct.getCost());
        assertEquals(product.getAmount(), newproduct.getAmount());
    }

}
