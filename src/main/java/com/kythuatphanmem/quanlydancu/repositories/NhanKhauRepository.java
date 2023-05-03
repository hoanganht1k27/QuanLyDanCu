package com.kythuatphanmem.quanlydancu.repositories;

import com.kythuatphanmem.quanlydancu.models.NhanKhau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanKhauRepository extends JpaRepository<NhanKhau, Long> {
}
