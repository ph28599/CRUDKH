package com.example.testthu.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "NgaySinh")
    private String ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "MatKhau")
    private String matKhau;

}
