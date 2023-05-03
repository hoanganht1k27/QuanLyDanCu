package com.kythuatphanmem.quanlydancu.services.impl;

import com.kythuatphanmem.quanlydancu.dto.NhanKhauDTO;
import com.kythuatphanmem.quanlydancu.models.NhanKhau;
import com.kythuatphanmem.quanlydancu.services.MappingService;
import org.springframework.stereotype.Service;

@Service
public class MappingServiceImpl implements MappingService {
    @Override
    public NhanKhauDTO convertNhanKhauIntoDTO(NhanKhau nhanKhau) {
        NhanKhauDTO res = new NhanKhauDTO();
        res.setId(nhanKhau.getId());
        res.setHoTen(nhanKhau.getHoTen());
        res.setBiDanh(nhanKhau.getBiDanh());
        res.setCccd(nhanKhau.getCccd());
        res.setDanToc(nhanKhau.getDanToc());
        res.setGioiTinh(nhanKhau.getGioiTinh());
        res.setNgaySinh(nhanKhau.getNgaySinh());
        res.setNgheNghiep(nhanKhau.getNgheNghiep());
        res.setQueQuan(nhanKhau.getQueQuan());
        res.setThuongTru(nhanKhau.getThuongTru());
        res.setNoiLamViec(nhanKhau.getNoiLamViec());
        return res;
    }
}
