/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.controller.admin;

import com.petshop.model.TaiKhoan;
import com.petshop.service.TaiKhoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/account")
public class AdminAccountController {

    private final TaiKhoanService service;

    public AdminAccountController(TaiKhoanService service){
        this.service = service;
    }

    @GetMapping
    public String list(Model model){

        model.addAttribute("accounts",service.findAll());

        return "admin/account-list";
    }

    @GetMapping("/create")
    public String createForm(Model model){

        model.addAttribute("account",new TaiKhoan());

        return "admin/account-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute TaiKhoan taiKhoan){

        service.save(taiKhoan);

        return "redirect:/admin/account";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        service.delete(id);

        return "redirect:/admin/account";
    }
}