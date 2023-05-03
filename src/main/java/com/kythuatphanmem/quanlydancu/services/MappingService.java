package com.kythuatphanmem.quanlydancu.services;

import com.kythuatphanmem.quanlydancu.dto.NhanKhauDTO;
import com.kythuatphanmem.quanlydancu.models.NhanKhau;

public interface MappingService {
    NhanKhauDTO convertNhanKhauIntoDTO(NhanKhau nhanKhau);
}
