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

public interface TaiKhoanService {

    TaiKhoan findByUsername(String username);

}