/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.security;

import com.petshop.model.TaiKhoan;
import com.petshop.repository.TaiKhoanRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final TaiKhoanRepository repository;

    public CustomUserDetailsService(TaiKhoanRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        System.out.println("LOGIN USERNAME: " + username);
        
        TaiKhoan taiKhoan = repository.findByUsername(username);

        if(taiKhoan == null){
             System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("FOUND USER: " + taiKhoan.getUsername());
        return new CustomUserDetails(taiKhoan);
    }
}