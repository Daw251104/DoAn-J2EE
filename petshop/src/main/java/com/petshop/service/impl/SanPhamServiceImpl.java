/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service.impl;

import com.petshop.model.SanPham;
import com.petshop.repository.SanPhamRepository;
import com.petshop.service.SanPhamService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    private final SanPhamRepository repository;

    public SanPhamServiceImpl(SanPhamRepository repository){
        this.repository = repository;
    }

    @Override
    public List<SanPham> findAll(){
        return repository.findAll();
    }

    @Override
    public SanPham findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public SanPham save(SanPham sanPham){
        return repository.save(sanPham);
    }

    @Override
    public void delete(Integer id){
        repository.deleteById(id);
    }
}