/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.controller.shop;

import com.petshop.service.DonHangService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop/orders")
public class OrderManageController {

    private final DonHangService service;

    public OrderManageController(DonHangService service){
        this.service = service;
    }

    @GetMapping
    public String list(Model model){

        model.addAttribute("orders",service.findAll());

        return "shop/order-manage";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable Integer id){

        service.updateStatus(id,"CONFIRMED");

        return "redirect:/shop/orders";
    }

    @GetMapping("/reject/{id}")
    public String reject(@PathVariable Integer id){

        service.updateStatus(id,"REJECTED");

        return "redirect:/shop/orders";
    }

    @GetMapping("/done/{id}")
    public String done(@PathVariable Integer id){

        service.updateStatus(id,"DONE");

        return "redirect:/shop/orders";
    }
}
