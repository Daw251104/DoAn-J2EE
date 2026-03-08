/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service;

/**
 *
 * @author datp4
 */
import com.petshop.model.TaiKhoan;

import java.util.List;

public interface TaiKhoanService {

    List<TaiKhoan> findAll();

    TaiKhoan findById(Integer id);

    TaiKhoan save(TaiKhoan taiKhoan);

    void delete(Integer id);

    TaiKhoan findByUsername(String username);

}