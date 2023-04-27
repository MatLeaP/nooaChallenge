package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Boya;
import com.example.demo.entities.Muestra;
import com.example.demo.model.request.MuestraRequest;
import com.example.demo.repo.BoyaRepo;
import com.example.demo.repo.MuestraRepo;

@Service
public class MuestraService {
    @Autowired
    MuestraRepo muestraRepo;
    @Autowired
    BoyaService boyaService;
    @Autowired
    BoyaRepo boyaRepo;


    /* Optional<Boya> optional = boyaService.findBoya(muestraRequest.idBoya);
        Muestra muestra = new Muestra(optional.get(), new Date(), muestraRequest.matriculaDeEmbarcacion, muestraRequest.latitud, muestraRequest.longitud, muestraRequest.alturaAlNivelDelMar);
        muestraService.grabar(muestra);
        return ResponseEntity.ok(muestra); */
    public boolean grabar(Muestra muestra){
        muestraRepo.save(muestra);
        return true;
    }

    public Muestra crearMuestra(MuestraRequest muestraRequest){
        Optional<Boya> optional = boyaService.findBoya(muestraRequest.idBoya);
        Muestra muestra = new Muestra(optional.get(), new Date(),muestraRequest.matriculaDeEmbarcacion, muestraRequest.latitud, muestraRequest.longitud, muestraRequest.alturaAlNivelDelMar, muestraRequest.colorLuz);
        double altura = muestraRequest.alturaAlNivelDelMar;
        if(altura < -100 || altura > 100){
            muestra.setColorLuz("rojo");   
        }else if(altura < -50 || altura > 50){
            muestra.setColorLuz("amarillo");
        }else{
            muestra.setColorLuz("verde");
        }
        grabar(muestra);
        return muestra;
    }

    public List<Muestra> findAllMuestrasByBoyaId(Integer idBoya){
        Optional<Boya> boyaOp = boyaRepo.findById(idBoya);
        if (boyaOp.isEmpty()){
            return new ArrayList();
        }
        return boyaOp.get().getMuestras();
    }
    
    public Optional<Muestra> findMuestra(Integer idMuestra){
        Optional<Muestra> muestraOp = muestraRepo.findById(idMuestra);
        if (muestraOp.isEmpty()){
            return Optional.empty();
        }
        return muestraOp;
    }

    public List<Muestra> listarMuestras(){
        return muestraRepo.findAll();
    }


    public Muestra resetearLuz(Integer idMuestra) throws Exception{
        Optional<Muestra> muestraOp = muestraRepo.findById(idMuestra);
        if (muestraOp.isEmpty()){
            throw new Exception("La cuenta no existe");
        }
        Muestra muestra = muestraOp.get();
        muestra.setColorLuz("AZUL");
        grabar(muestra);
        return muestra;
    }

    public List<Muestra> muestrasPorColor(String color) throws Exception {
        List<Muestra> muestra = listarMuestras();
        if (muestra == null) {
            return Collections.emptyList();
        }
        return muestra.stream()
                .filter(m -> color.equals(m.getColorLuz()))
                .peek(m -> m.getBoya().getIdDeBoya())
                .collect(Collectors.toList());
    }
    
    
    
}
