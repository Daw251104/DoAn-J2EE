/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service.impl;

import com.petshop.model.TaiKhoan;
import com.petshop.repository.TaiKhoanRepository;
import com.petshop.service.TaiKhoanService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    private final TaiKhoanRepository repository;

    public TaiKhoanServiceImpl(TaiKhoanRepository repository){
        this.repository = repository;
    }

    @Override
    public List<TaiKhoan> findAll(){
        return repository.findAll();
    }

    @Override
    public TaiKhoan findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public TaiKhoan save(TaiKhoan taiKhoan){
        return repository.save(taiKhoan);
    }

    @Override
    public void delete(Integer id){
        repository.deleteById(id);
    }

    @Override
    public TaiKhoan findByUsername(String username){
        return repository.findByUsername(username);
    }
}
