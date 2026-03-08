/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service.impl;

import com.petshop.model.*;
import com.petshop.repository.*;

import com.petshop.service.DonHangService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonHangServiceImpl implements DonHangService {

    private final DonHangRepository donHangRepository;
    private final GioHangRepository gioHangRepository;
    private final TaiKhoanRepository taiKhoanRepository;

    public DonHangServiceImpl(DonHangRepository donHangRepository,
                              GioHangRepository gioHangRepository,
                              TaiKhoanRepository taiKhoanRepository) {
        this.donHangRepository = donHangRepository;
        this.gioHangRepository = gioHangRepository;
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public void createOrder(Integer userId) {

        TaiKhoan user = taiKhoanRepository.findById(userId).orElseThrow();

        List<GioHang> carts = gioHangRepository.findByTaiKhoan_MaTK(userId);

        DonHang order = new DonHang();
        order.setKhachHang(user);
        order.setNgayLapDonHang(LocalDateTime.now());
        order.setTrangThai("PENDING");

        donHangRepository.save(order);

        gioHangRepository.deleteAll(carts);
    }
}
