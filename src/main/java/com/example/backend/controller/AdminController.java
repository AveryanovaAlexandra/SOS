package com.example.backend.controller;

import com.example.backend.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Admin;
import com.example.backend.repository.AdminRepository;
import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin")
    public Admin getAdmin(){
        return adminRepository.findAll().get(0);
    }
    @PutMapping("/admin/{id}")
    public ResponseEntity<Object> updateAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        admin.setId(id);
        Admin savedAdmin = adminRepository.save(admin);
        return new ResponseEntity<Object>(savedAdmin, HttpStatus.OK);

    }

}
