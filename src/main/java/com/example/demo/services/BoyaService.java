package com.example.demo.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Boya;
import com.example.demo.model.request.BoyaColorRequest;
import com.example.demo.repo.BoyaRepo;

@Service
public class BoyaService {
    
    @Autowired
    BoyaRepo boyaRepo;

    public boolean grabar(Boya boya){
        boyaRepo.save(boya);
        return true;
    }


    public Boya crearBoya(double longitudInstalacion, double latitudInstalacion) {
        Boya boya = new Boya(longitudInstalacion,  latitudInstalacion );
        grabar(boya);
        return boya;
    }

    public List<Boya> obtenerBoyas() {
        return boyaRepo.findAll();
    }


    public Optional<Boya> findBoya(Integer idBoya){
        Optional<Boya> boyaop = boyaRepo.findById(idBoya);
        if (boyaop.isEmpty()){
            return Optional.empty();
        }
        return boyaop;
    }

    public Boya modificarBoya(Integer id, BoyaColorRequest boya) throws Exception{
        Optional<Boya> boyaOp = findBoya(id);
        if (boyaOp.isEmpty()){
            throw new Exception("La boya no existe");
        }
        Boya boya1 = boyaOp.get();
        boya1.setColorLuz(boya.colorLuz);
        try{
            grabar(boya1);
            return boya1;
        }catch (Exception e) {
            throw new Exception("Error");
        }
    }
}

