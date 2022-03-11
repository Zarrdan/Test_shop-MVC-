package ru.pcs.example.javashop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pcs.example.javashop.JavashopApplicationTests;
import ru.pcs.example.javashop.forms.CustomerForm;
import ru.pcs.example.javashop.forms.ProductForm;
import ru.pcs.example.javashop.models.Customer;
import ru.pcs.example.javashop.models.Product;
import ru.pcs.example.javashop.services.CustomersServiceImpl;
import ru.pcs.example.javashop.services.ProductsServiceImpl;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomersServiceImplTest extends JavashopApplicationTests {
    @Autowired
    private ProductsServiceImpl productsService;
    ProductForm productForm = ProductForm.builder()
            .name("Macbook")
            .cost(10000)
            .amount(1)
            .build();


    @Autowired
    private CustomersServiceImpl customersService;
    CustomerForm customerForm = CustomerForm.builder()
            .first_Name("Пример1")
            .last_Name("Пример1")
            .phone("+79046791921")
            .email("111@mail.ru")
            .adress("Казань")
            .build();

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = customersService.getAllCustomers();
        assertNotNull(customers);
    }

    @Test
    void testGetCustomer() {

        Customer createdCustomer = customersService.addCustomer(customerForm);
        Customer customer = customersService.getCustomer(createdCustomer.getId());

        assertNotNull(customer);
        assertEquals(customer.getFirst_Name(), createdCustomer.getFirst_Name());
        assertEquals(customer.getLast_Name(), createdCustomer.getLast_Name());
        assertEquals(customer.getPhone(), createdCustomer.getPhone());
        assertEquals(customer.getEmail(), createdCustomer.getEmail());
        assertEquals(customer.getAdress(), createdCustomer.getAdress());
    }

    @Test
    void testAddCustomer() {
        Customer createCustomer = customersService.addCustomer(customerForm);

        assertNotNull(createCustomer.getId());
        assertEquals(customerForm.getFirst_Name(), createCustomer.getFirst_Name());
        assertEquals(customerForm.getLast_Name(), createCustomer.getLast_Name());
        assertEquals(customerForm.getPhone(), createCustomer.getPhone());
        assertEquals(customerForm.getEmail(), createCustomer.getEmail());
        assertEquals(customerForm.getAdress(), createCustomer.getAdress());
    }

    @Test
    void testUpdateCustomer() {
        CustomerForm customerFormUpdate = CustomerForm.builder()
                .first_Name("Пример2")
                .last_Name("Пример2")
                .phone("+76046587441")
                .email("777@mail.ru")
                .adress("Москва")
                .build();
        Customer oldCustomer = customersService.addCustomer(customerForm);
        Customer newCustomer = customersService.updateCustomer(oldCustomer.getId(), customerFormUpdate);

        assertEquals(oldCustomer.getId(), newCustomer.getId(), "Ids shouldn't be changed during the update");
        assertNotEquals(oldCustomer.getFirst_Name(), newCustomer.getFirst_Name());
        assertNotEquals(oldCustomer.getLast_Name(), newCustomer.getLast_Name());
        assertNotEquals(oldCustomer.getPhone(), newCustomer.getPhone());
        assertNotEquals(oldCustomer.getEmail(), newCustomer.getEmail());
        assertNotEquals(oldCustomer.getAdress(), newCustomer.getAdress());
    }

    @Test
    void testDeleteCustomer() {
        Customer createdCustomer = customersService.addCustomer(customerForm);
        customersService.deleteCustomer(createdCustomer.getId());
    }

    @Test
    void testAddProductToCustomer() {
        Product product = productsService.addProduct(productForm);
        Customer customer = customersService.addCustomer(customerForm);
        product = customersService.addProductToCustomer(customer.getId(), product.getId());

        assertNotNull(product.getCustomer());
        assertEquals(customer.getFirst_Name(), product.getCustomer().getFirst_Name());
        assertEquals(customer.getLast_Name(), product.getCustomer().getLast_Name());
        assertEquals(customer.getPhone(), product.getCustomer().getPhone());
        assertEquals(customer.getEmail(), product.getCustomer().getEmail());
        assertEquals(customer.getAdress(), product.getCustomer().getAdress());
    }

    @Test
    void testDeleteProductToCustomer() {
        Product product = productsService.addProduct(productForm);
        Customer customer = customersService.addCustomer(customerForm);

        product = customersService.addProductToCustomer(customer.getId(), product.getId());
        assertNotNull(product.getCustomer());

        product = customersService.deleteProductToCustomer(product.getId());
        assertNull(product.getCustomer());
    }

    @Test
    void testGetProductsByCustomer() {
        Product product = productsService.addProduct(productForm);
        Customer customer = customersService.addCustomer(customerForm);

        product = customersService.addProductToCustomer(customer.getId(), product.getId());
        List<Product> products = customersService.getProductsByCustomer(product.getId());
        assertNotNull(products);
    }

    @Test
    void testGetProductWithoutCustomer() {
        Product product = productsService.addProduct(productForm);
        List<Product> products = customersService.getProductWithoutCustomer();
        assertNotNull(products);
    }

}

