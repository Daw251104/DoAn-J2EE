/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service.impl;

import com.petshop.model.TaiKhoan;
import com.petshop.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petshop.service.TaiKhoanService;
/**
 *
 * @author datp4
 */
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository repo;
    @Override
    public TaiKhoan findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
