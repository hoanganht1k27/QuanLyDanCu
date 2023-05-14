package com.kythuatphanmem.quanlydancu.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;

@Entity
@Data
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("authorities")
    private MyUser user;

    @Transactional
    @Override
    public String toString() {
        return "Authority: " + name;
    }
}
