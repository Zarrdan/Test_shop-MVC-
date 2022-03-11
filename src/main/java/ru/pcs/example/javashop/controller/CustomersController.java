package ru.pcs.example.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pcs.example.javashop.forms.CustomerForm;
import ru.pcs.example.javashop.models.Customer;
import ru.pcs.example.javashop.models.Product;
import ru.pcs.example.javashop.services.CustomersService;


import java.util.List;

@Controller
public class CustomersController {

    private final CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/customers")
    public String getCustomersPage(Model model) {
        List<Customer> customerList = customersService.getAllCustomers();
        model.addAttribute("customers", customerList);
        return "customers";
    }

    @GetMapping("/customers/{customer-id}")
    public String getCustomerPage(Model model, @PathVariable("customer-id") Integer customerId) {
        Customer customer = customersService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "customer";
    }

    @PostMapping("/customers")
    public String addCustomer(CustomerForm form) {
        customersService.addCustomer(form);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{customer-id}/delete")
    public String deleteCustomer(@PathVariable("customer-id") Integer customerId) {
        customersService.deleteCustomer(customerId);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{customer-id}/update")
    public String updateCustomer(@PathVariable("customer-id") Integer customerId, CustomerForm form) {
        customersService.updateCustomer(customerId, form);
        return "redirect:/customers";
    }

    @GetMapping("/customers/{customer-id}/products")
    public String getProductsByCustomer(Model model, @PathVariable("customer-id") Integer customerId) {
        List<Product> products = customersService.getProductsByCustomer(customerId);
        List<Product> unusedProducts = customersService.getProductWithoutCustomer();
        model.addAttribute("customerId", customerId);
        model.addAttribute("products", products);
        model.addAttribute("unusedProducts", unusedProducts);
        return "products_of_customer";
    }

    @PostMapping("/customers/{customer-id}/products")
    public String addProductToCustomer(@PathVariable("customer-id") Integer customerId, @RequestParam("productId") Integer productId) {
        customersService.addProductToCustomer(customerId, productId);
        return "redirect:/customers/" + customerId + "/products";
    }

    @PostMapping("/customers/{customer-id}/products/delete")
    public String deleteProductToCustomer(@PathVariable("customer-id") Integer customerId, @RequestParam("productId") Integer productId) {
        customersService.deleteProductToCustomer(productId);
        return "redirect:/customers/" + customerId + "/products";
    }
}
