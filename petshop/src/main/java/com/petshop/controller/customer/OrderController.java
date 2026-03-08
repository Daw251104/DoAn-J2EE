/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.controller.customer;

import com.petshop.service.DonHangService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final DonHangService donHangService;

    public OrderController(DonHangService donHangService) {
        this.donHangService = donHangService;
    }

    @PostMapping("/checkout/{userId}")
    public void checkout(@PathVariable Integer userId) {
        donHangService.createOrder(userId);
    }
}
