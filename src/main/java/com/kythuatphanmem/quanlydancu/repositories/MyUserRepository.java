package com.kythuatphanmem.quanlydancu.repositories;

import com.kythuatphanmem.quanlydancu.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    List<MyUser> findByEmail(String email);
}
