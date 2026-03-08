/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.controller.shop;

import com.petshop.model.SanPham;
import com.petshop.repository.SanPhamRepository;
import com.petshop.service.SanPhamService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/shop/products")
public class ProductController {

    private final SanPhamService service;

    public ProductController(SanPhamService service){
        this.service = service;
    }

    @GetMapping
    public String list(Model model){

        model.addAttribute("products",service.findAll());

        return "shop/product-list";
    }

    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("product",new SanPham());

        return "shop/product-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SanPham sanPham){

        service.save(sanPham);

        return "redirect:/shop/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        service.delete(id);

        return "redirect:/shop/products";
    }
}
