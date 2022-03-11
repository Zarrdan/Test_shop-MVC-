package ru.pcs.example.javashop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.example.javashop.forms.SellerForm;
import ru.pcs.example.javashop.models.Product;
import ru.pcs.example.javashop.models.Seller;
import ru.pcs.example.javashop.repositories.ProductRepository;
import ru.pcs.example.javashop.repositories.SellerRepository;


import java.util.List;

@Component
@RequiredArgsConstructor
public class SellersServiceImpl implements SellersService {
    private final SellerRepository sellerRepository;
    final ProductRepository productRepository;

    @Override
    public Seller addSeller(SellerForm form) {
        Seller seller = Seller.builder()
                .entity(form.getEntity())
                .phone(form.getPhone())
                .email(form.getEmail())
                .adress(form.getAdress())
                .build();
        sellerRepository.save(seller);
        return seller;
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public void deleteSeller(Integer sellerId) {
        sellerRepository.deleteById(sellerId);
    }

    @Override
    public Seller updateSeller(Integer sellerId, SellerForm form) {
        Seller seller = Seller.builder()
                .id(sellerId)
                .entity(form.getEntity())
                .phone(form.getPhone())
                .email(form.getEmail())
                .adress(form.getAdress())
                .build();
        return sellerRepository.save(seller);
    }

    @Override
    public Seller getSeller(Integer sellerId) {
        return sellerRepository.getById(sellerId);
    }

    @Override
    public List<Product> getProductsBySeller(Integer sellerId) {
        return productRepository.findAllBySeller_Id(sellerId);
    }
}

