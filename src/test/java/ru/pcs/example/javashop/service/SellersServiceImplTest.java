package ru.pcs.example.javashop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pcs.example.javashop.JavashopApplicationTests;
import ru.pcs.example.javashop.forms.SellerForm;
import ru.pcs.example.javashop.models.Seller;
import ru.pcs.example.javashop.services.SellersServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SellersServiceImplTest extends JavashopApplicationTests {


    @Autowired
    private SellersServiceImpl sellersService;
    SellerForm sellerForm = SellerForm.builder()
            .entity("Рога и копыта")
            .phone("77777777")
            .email("777777@mail.ru")
            .adress("Казань Баумана 70")
            .build();

    @Test
    void testgetAllSellers() {
        List<Seller> sellers = sellersService.getAllSellers();
        assertNotNull(sellers);
    }

    @Test
    void deleteSeller() {
        Seller createdSeller = sellersService.addSeller(sellerForm);
        sellersService.deleteSeller(createdSeller.getId());

    }

    @Test
    void testupdateSeller() {
        SellerForm sellerFormUpdate = SellerForm.builder()
                .entity("Лавка")
                .phone("+8888888")
                .email("88888@mail.ru")
                .adress("Казань ул Петербуская д.35")
                .build();
        Seller oldseller = sellersService.addSeller(sellerForm);
        Seller newseller = sellersService.updateSeller(oldseller.getId(), sellerFormUpdate);

        assertEquals(oldseller.getId(), newseller.getId(), "Ids shouldn't be changed during the update");
        assertNotEquals(oldseller.getEntity(), newseller.getEntity());
        assertNotEquals(oldseller.getPhone(), newseller.getPhone());
        assertNotEquals(oldseller.getEmail(), newseller.getEmail());
        assertNotEquals(oldseller.getAdress(), newseller.getAdress());
    }

    @Test
    void testgetSeller() {
        Seller createdseller = sellersService.addSeller(sellerForm);
        Seller seller = sellersService.getSeller(createdseller.getId());

        assertNotNull(seller);
        assertEquals(seller.getEntity(), createdseller.getEntity());
        assertEquals(seller.getPhone(), createdseller.getPhone());
        assertEquals(seller.getEmail(), createdseller.getEmail());
        assertEquals(seller.getAdress(), createdseller.getAdress());
    }

}
