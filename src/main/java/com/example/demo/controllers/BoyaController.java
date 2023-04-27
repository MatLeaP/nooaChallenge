package com.example.demo.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Boya;
import com.example.demo.services.BoyaService;
import com.example.demo.model.request.BoyaColorRequest;
import com.example.demo.model.request.BoyaRequest;



@RestController
public class BoyaController {
    @Autowired
    BoyaService boyaService;
    
    @PostMapping("/crearBoya")
    public ResponseEntity<Boya> crearBoya(@RequestBody BoyaRequest boyaRequest){
        Boya boya = boyaService.crearBoya(boyaRequest.latitudInstalacion, boyaRequest.longitudInstalacion);
        return ResponseEntity.ok(boya);
    }

    @GetMapping("/boyas")
    public ResponseEntity<List<Boya>> obtenerBoyas(){   
        List<Boya> boyas = boyaService.obtenerBoyas();
        return ResponseEntity.ok(boyas);
    }
    
    @GetMapping("/boyas/{id}")
    public ResponseEntity<Boya> findBoyaById(@PathVariable Integer id){
        Optional<Boya> boyaOp = boyaService.findBoya(id);
        return ResponseEntity.ok(boyaOp.get());
    }
    
    
    @PutMapping("/boyas/{id}")
    public ResponseEntity<Boya> modificarBoya(@PathVariable Integer id, @RequestBody BoyaColorRequest boya) throws Exception{
        Boya boya1 = boyaService.modificarBoya(id, boya);
        return ResponseEntity.ok(boya1);
    }
}
