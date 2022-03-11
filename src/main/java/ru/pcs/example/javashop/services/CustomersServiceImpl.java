package ru.pcs.example.javashop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.example.javashop.forms.CustomerForm;
import ru.pcs.example.javashop.models.Customer;
import ru.pcs.example.javashop.models.Product;
import ru.pcs.example.javashop.repositories.CustomerRepository;
import ru.pcs.example.javashop.repositories.ProductRepository;



import java.util.List;

@RequiredArgsConstructor //нужен чтобы не писать афтовайред, когда создаешь репозитории
@Component
public class CustomersServiceImpl implements CustomersService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    public Customer addCustomer(CustomerForm form) {
        Customer customer = Customer.builder()
                .first_Name(form.getFirst_Name())
                .last_Name(form.getLast_Name())
                .phone(form.getPhone())
                .email(form.getEmail())
                .adress(form.getAdress())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        return customerRepository.getById(customerId);
    }

    @Override
    public Customer updateCustomer(Integer customerId, CustomerForm form) {
        Customer customer = Customer.builder()
                .id(customerId)
                .first_Name(form.getFirst_Name())
                .last_Name(form.getLast_Name())
                .phone(form.getPhone())
                .email(form.getEmail())
                .adress(form.getAdress())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public List<Product> getProductsByCustomer(Integer customerId) {
        return productRepository.findAllByCustomer_Id(customerId);
    }

    @Override
    public List<Product> getProductWithoutCustomer() {
        return productRepository.findAllByCustomerIsNull();
    }

    @Override
    public Product addProductToCustomer(Integer customerId, Integer productId) {
        Customer customer = customerRepository.getById(customerId);
        Product product = productRepository.getById(productId);
        product.setCustomer(customer);
        return   productRepository.save(product);
    }

    @Override
    public Product deleteProductToCustomer(Integer productId) {
        Product product = productRepository.getById(productId);
        product.setCustomer(null);
        return productRepository.save(product);
    }

}

