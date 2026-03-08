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

import java.util.List;

@Entity
@Table(name = "LOAI_TK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiTaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLoaiTK;

    private String tenLoaiTK;

    @OneToMany(mappedBy = "loaiTaiKhoan")
    private List<TaiKhoan> taiKhoans;
}