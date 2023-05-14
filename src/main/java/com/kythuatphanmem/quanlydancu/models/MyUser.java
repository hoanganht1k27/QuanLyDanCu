package com.kythuatphanmem.quanlydancu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String pwd;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("user")
    private List<Authority> authorities;
}
