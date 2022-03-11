package ru.pcs.example.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pcs.example.javashop.forms.SellerForm;
import ru.pcs.example.javashop.models.Seller;
import ru.pcs.example.javashop.services.SellersService;


import java.util.List;

@Controller
public class SellersController {

    private final SellersService sellersService;

    @Autowired
    public SellersController(SellersService sellersService) {
        this.sellersService = sellersService;
    }

    @GetMapping("/sellers")
    public String getSellersPage(Model model) {
        List<Seller> sellers = sellersService.getAllSellers();
        model.addAttribute("sellers", sellers);
        return "sellers";
    }

    @GetMapping("/sellers/{seller-id}")
    public String getSellerPage(Model model, @PathVariable("seller-id") Integer sellerId) {
        Seller seller = sellersService.getSeller(sellerId);
        model.addAttribute("seller", seller);
        return "seller";
    }

    @PostMapping("/sellers")
    public String addSeller(SellerForm form) {
        sellersService.addSeller(form);
        return "redirect:/sellers";
    }

    @PostMapping("/sellers/{seller-id}/delete")
    public String deleteSeller(@PathVariable("seller-id") Integer sellerId) {
        sellersService.deleteSeller(sellerId);
        return "redirect:/sellers";
    }

    //изменение
    @PostMapping("/sellers/{seller-id}/update")
    public String updateSeller(@PathVariable("seller-id") Integer sellerId, SellerForm form) {
        sellersService.updateSeller(sellerId, form);
        return "redirect:/sellers";
    }
}

