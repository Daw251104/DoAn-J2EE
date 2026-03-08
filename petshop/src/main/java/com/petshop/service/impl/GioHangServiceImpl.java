/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service.impl;

import com.petshop.model.GioHang;
import com.petshop.model.SanPham;
import com.petshop.model.TaiKhoan;
import com.petshop.repository.GioHangRepository;
import com.petshop.repository.SanPhamRepository;
import com.petshop.repository.TaiKhoanRepository;
import com.petshop.service.GioHangService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangServiceImpl implements GioHangService {

    private final GioHangRepository gioHangRepository;
    private final SanPhamRepository sanPhamRepository;
    private final TaiKhoanRepository taiKhoanRepository;

    public GioHangServiceImpl(GioHangRepository gioHangRepository,
                              SanPhamRepository sanPhamRepository,
                              TaiKhoanRepository taiKhoanRepository) {
        this.gioHangRepository = gioHangRepository;
        this.sanPhamRepository = sanPhamRepository;
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public List<GioHang> getCart(Integer userId) {
        return gioHangRepository.findByTaiKhoan_MaTK(userId);
    }

    @Override
    public void addToCart(Integer userId, Integer productId, Integer quantity) {

        TaiKhoan user = taiKhoanRepository.findById(userId).orElseThrow();
        SanPham product = sanPhamRepository.findById(productId).orElseThrow();

        GioHang cart = new GioHang();
        cart.setTaiKhoan(user);
        cart.setSanPham(product);
        cart.setSoLuong(quantity);

        gioHangRepository.save(cart);
    }

    @Override
    public void removeCart(Integer cartId) {
        gioHangRepository.deleteById(cartId);
    }
    @Override
    public void clearCart(Integer userId){
        gioHangRepository.deleteAll();
    }
}