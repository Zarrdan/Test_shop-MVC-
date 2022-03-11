package ru.pcs.example.javashop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pcs.example.javashop.forms.ProductForm;
import ru.pcs.example.javashop.models.Product;
import ru.pcs.example.javashop.services.ProductsService;


import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public String getProductsPage(Model model) {
        List<Product> productList = productsService.getAllProducts();
        model.addAttribute("products", productList);
        return "products";
    }

    @GetMapping("/products/{product-id}")
    public String getProductPage(Model model, @PathVariable("product-id") Integer productId) {
        Product product = productsService.getProduct(productId);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/products")
    public String addProduct(ProductForm form) {
        productsService.addProduct(form);
        return "redirect:/products";
    }

    @PostMapping("/products/{product-id}/delete")
    public String deleteProduct(@PathVariable("product-id") Integer productId) {
        productsService.deleteProduct(productId);
        return "redirect:/products";
    }

    @PostMapping("/products/{product-id}/update")
    public String updateProduct(@PathVariable("product-id") Integer productId, ProductForm form) {
        productsService.updateProduct(productId, form);
        return "redirect:/products";
    }
}

