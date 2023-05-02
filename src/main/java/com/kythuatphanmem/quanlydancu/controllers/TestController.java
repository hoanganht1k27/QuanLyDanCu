package com.kythuatphanmem.quanlydancu.controllers;

import com.kythuatphanmem.quanlydancu.models.Test;
import com.kythuatphanmem.quanlydancu.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestRepository testRepository;
    @GetMapping("/")
    public List<Test> home() {
        return testRepository.findAll();
    }
}
