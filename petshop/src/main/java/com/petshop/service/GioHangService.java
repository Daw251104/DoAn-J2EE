/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.service;

import com.petshop.model.GioHang;
import java.util.List;

public interface GioHangService {

    List<GioHang> getCart(Integer userId);

    void addToCart(Integer userId, Integer productId, Integer quantity);

    void removeCart(Integer cartId);

}
