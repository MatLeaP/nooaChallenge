package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "boya")
public class Boya{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boya")
    private Integer idBoya;

    @Column(name = "color")    
    private String colorLuz;    

    @Column(name = "longitud_instalacion")
    private double longitudDeInstalacion;
    
    @Column(name = "latitud_instalacion")
    private double latitudDeInstalacion;

    @JsonManagedReference
    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List <Muestra> muestras = new ArrayList<>();

    

    public Boya(){
        
    }

    public Boya(double longitudDeInstalacion, double latitudDeInstalacion){
        this.setLongitudDeInstalacion(longitudDeInstalacion);
        this.setLatitudDeInstalacion(latitudDeInstalacion);
    }



    public Integer getIdDeBoya() {
        return idBoya;
    }


    public String getColorLuz() {
        return colorLuz;
    }

    public void setColorLuz(String colorLuz) {
        this.colorLuz = colorLuz;
    }

    public double getLongitudDeInstalacion() {
        return longitudDeInstalacion;
    }

    public void setLongitudDeInstalacion(double longitudDeInstalacion) {
        this.longitudDeInstalacion = longitudDeInstalacion;
    }
    
    public double getLatitudDeInstalacion() {
        return latitudDeInstalacion;
    }

    public void setLatitudDeInstalacion(double latitudDeInstalacion) {
        this.latitudDeInstalacion = latitudDeInstalacion;
    }
    
    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }
   
    
    
}