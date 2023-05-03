package com.kythuatphanmem.quanlydancu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hoTen;
    private String biDanh;
    private String cccd;
    private Date ngaySinh;
    private String gioiTinh;
    private String queQuan;
    private String thuongTru;
    private String danToc;
    private String ngheNghiep;
    private String noiLamViec;
}
