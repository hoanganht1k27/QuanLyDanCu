package com.kythuatphanmem.quanlydancu.controllers;

import com.kythuatphanmem.quanlydancu.dto.NhanKhauDTO;
import com.kythuatphanmem.quanlydancu.models.NhanKhau;
import com.kythuatphanmem.quanlydancu.services.NhanKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class NhanKhauController {
    @Autowired
    private NhanKhauService nhanKhauService;

    @GetMapping("/nhan-khau")
    public String getAllNhanKhau() {
        return "Nhan khau all";
    }
}
