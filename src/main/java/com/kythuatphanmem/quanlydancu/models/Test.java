package com.kythuatphanmem.quanlydancu.models;

import jakarta.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

}
