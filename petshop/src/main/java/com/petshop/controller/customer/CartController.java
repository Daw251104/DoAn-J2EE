/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.controller.customer;

import com.petshop.model.GioHang;
import com.petshop.service.GioHangService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final GioHangService service;

    public CartController(GioHangService service){
        this.service = service;
    }

    @GetMapping
    public String cart(Model model){

        model.addAttribute("cart",service.getCart(1));

        return "customer/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable Integer id){

        service.removeCart(id);

        return "redirect:/cart";
    }
}