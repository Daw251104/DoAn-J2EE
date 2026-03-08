/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.model;

/**
 *
 * @author datp4
 */
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SANPHAM_THUCUNG")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SanPhamThuCungId.class)
public class SanPhamThuCung {

    @Id
    @ManyToOne
    @JoinColumn(name = "MASP")
    private SanPham sanPham;

    @Id
    @ManyToOne
    @JoinColumn(name = "MALOAITC")
    private LoaiThuCung loaiThuCung;
}
