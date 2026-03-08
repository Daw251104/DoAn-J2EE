/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.controller.customer;

import com.petshop.model.GioHang;
import com.petshop.service.GioHangService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final GioHangService gioHangService;

    public CartController(GioHangService gioHangService) {
        this.gioHangService = gioHangService;
    }

    @GetMapping("/{userId}")
    public List<GioHang> getCart(@PathVariable Integer userId) {
        return gioHangService.getCart(userId);
    }

    @PostMapping("/add")
    public void addCart(@RequestParam Integer userId,
                        @RequestParam Integer productId,
                        @RequestParam Integer quantity) {

        gioHangService.addToCart(userId, productId, quantity);
    }

}