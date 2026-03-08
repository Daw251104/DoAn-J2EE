/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.controller.shop;

import com.petshop.model.SanPham;
import com.petshop.repository.SanPhamRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/products")
public class ProductController {

    private final SanPhamRepository sanPhamRepository;

    public ProductController(SanPhamRepository sanPhamRepository) {
        this.sanPhamRepository = sanPhamRepository;
    }

    @GetMapping
    public List<SanPham> getAllProducts() {
        return sanPhamRepository.findAll();
    }

    @PostMapping
    public SanPham createProduct(@RequestBody SanPham product) {
        return sanPhamRepository.save(product);
    }

}
