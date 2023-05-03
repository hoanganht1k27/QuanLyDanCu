package com.kythuatphanmem.quanlydancu.services.impl;

import com.kythuatphanmem.quanlydancu.dto.NhanKhauDTO;
import com.kythuatphanmem.quanlydancu.models.NhanKhau;
import com.kythuatphanmem.quanlydancu.repositories.NhanKhauRepository;
import com.kythuatphanmem.quanlydancu.services.MappingService;
import com.kythuatphanmem.quanlydancu.services.NhanKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhanKhauServiceImpl implements NhanKhauService {
    @Autowired
    private NhanKhauRepository nhanKhauRepository;
    @Autowired
    private MappingService mappingService;
    @Override
    public List<NhanKhauDTO> getAll() {
        return nhanKhauRepository.findAll()
                .stream()
                .map(mappingService::convertNhanKhauIntoDTO)
                .collect(Collectors.toList());
    }
}
