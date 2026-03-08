/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service.impl;

import com.petshop.model.DonHang;
import com.petshop.repository.DonHangRepository;
import com.petshop.service.DonHangService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DonHangServiceImpl implements DonHangService {

    private final DonHangRepository repository;

    public DonHangServiceImpl(DonHangRepository repository){
        this.repository = repository;
    }

    @Override
    public List<DonHang> findAll(){
        return repository.findAll();
    }

    @Override
    public DonHang findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public DonHang save(DonHang donHang){
        return repository.save(donHang);
    }

    @Override
    public void updateStatus(Integer id,String status){

        DonHang donHang = repository.findById(id).orElse(null);

        if(donHang != null){
            donHang.setTrangThai(status);
            repository.save(donHang);
        }

    }
}
