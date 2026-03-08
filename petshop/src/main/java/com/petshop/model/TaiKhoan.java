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

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TAI_KHOAN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maTK;

    @Column(unique = true)
    private String username;

    private String password;

    private String hoTen;

    private String gioiTinh;

    private String sdt;

    private String email;

    private String diaChi;

    private Integer trangThai;

    private LocalDateTime ngayTao;

    @ManyToOne
    @JoinColumn(name = "maloaitk")
    private LoaiTaiKhoan loaiTaiKhoan;

    @OneToMany(mappedBy = "khachHang")
    private List<DonHang> donHangs;
}