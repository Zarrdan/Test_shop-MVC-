package ru.pcs.example.javashop.services;

import ru.pcs.example.javashop.forms.SellerForm;
import ru.pcs.example.javashop.models.Product;
import ru.pcs.example.javashop.models.Seller;

import java.util.List;

public interface SellersService {

    Seller addSeller(SellerForm form);

    List<Seller> getAllSellers();

    void deleteSeller(Integer sellerId);

    Seller updateSeller(Integer sellerId, SellerForm form);

    Seller getSeller(Integer sellerId);

    List<Product> getProductsBySeller(Integer sellerId);

}

