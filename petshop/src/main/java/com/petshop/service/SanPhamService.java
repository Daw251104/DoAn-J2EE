/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service;

import com.petshop.model.SanPham;
import java.util.List;

public interface SanPhamService {

    List<SanPham> findAll();

    SanPham findById(Integer id);

    SanPham save(SanPham sanPham);

    void delete(Integer id);

}
