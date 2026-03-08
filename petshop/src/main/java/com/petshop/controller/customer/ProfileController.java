/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.controller.customer;

import com.petshop.model.TaiKhoan;
import com.petshop.service.TaiKhoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final TaiKhoanService service;

    public ProfileController(TaiKhoanService service){
        this.service = service;
    }

    @GetMapping
    public String profile(Model model){

        model.addAttribute("user",service.findById(1));

        return "customer/profile";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute TaiKhoan taiKhoan){

        service.save(taiKhoan);

        return "redirect:/profile";
    }
}