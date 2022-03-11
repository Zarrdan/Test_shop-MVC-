package ru.pcs.example.javashop.services;


import ru.pcs.example.javashop.forms.CustomerForm;
import ru.pcs.example.javashop.models.Customer;
import ru.pcs.example.javashop.models.Product;


import java.util.List;

public interface CustomersService {

    Customer addCustomer(CustomerForm form);

    List<Customer> getAllCustomers();

    void deleteCustomer(Integer customerId);

    Customer getCustomer(Integer customerId);

    Customer updateCustomer(Integer productId, CustomerForm form);

    List<Product> getProductsByCustomer(Integer customerId);

    List<Product> getProductWithoutCustomer();

    Product addProductToCustomer(Integer customerId, Integer productId);

    Product deleteProductToCustomer(Integer productId);
}

