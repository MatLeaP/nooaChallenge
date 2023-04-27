package com.example.demo.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Boya;
import com.example.demo.entities.Muestra;
import com.example.demo.model.request.MuestraRequest;
import com.example.demo.services.BoyaService;
import com.example.demo.services.MuestraService;



@RestController
public class MuestraController {
    

    @Autowired
    MuestraService muestraService;

    @Autowired
    BoyaService boyaService;

    @PostMapping("/muestras")
    public ResponseEntity<Muestra> crearMuestra(@RequestBody MuestraRequest muestraRequest){
        Muestra muestra = muestraService.crearMuestra(muestraRequest);
        return ResponseEntity.ok(muestra);
    }

    @GetMapping("/muestras")
    public ResponseEntity<List<Muestra>> obtenerMuestras(){   
        List<Muestra> muestras = muestraService.listarMuestras();
        return ResponseEntity.ok(muestras);
    }

    @GetMapping("/muestras/{id}")
    public ResponseEntity<Muestra> findMuestraById(@PathVariable Integer id){
        Optional<Muestra> muestraOp = muestraService.findMuestra(id);
        return ResponseEntity.ok(muestraOp.get());
    }
    
    @GetMapping("/muestras/colores/{color}")
    public ResponseEntity<List<Muestra>> muestrasPorColor(@PathVariable String color) throws Exception{
        List<Muestra> muestras = muestraService.muestrasPorColor(color);
        return ResponseEntity.ok(muestras);
    }
    
    @GetMapping("/muestras/boyas/{id}")
    public ResponseEntity<List<Muestra>> obtenerMuestrasByBoyaId(@PathVariable int id){
            List<Muestra> muestraBoya = muestraService.findAllMuestrasByBoyaId(id);
            return ResponseEntity.ok(muestraBoya);     
    
    }

    @DeleteMapping("/muestras/{id}")
    public ResponseEntity<Muestra> reseteoLuz(@PathVariable Integer id) throws Exception{
        Muestra muestra = muestraService.resetearLuz(id);
        return ResponseEntity.ok(muestra);
    }

}