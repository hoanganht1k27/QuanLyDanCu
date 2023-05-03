package com.kythuatphanmem.quanlydancu.services;

import com.kythuatphanmem.quanlydancu.dto.NhanKhauDTO;
import com.kythuatphanmem.quanlydancu.models.NhanKhau;

import java.util.List;

public interface NhanKhauService {
    List<NhanKhauDTO> getAll();
}
