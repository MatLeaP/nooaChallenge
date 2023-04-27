package com.example.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "muestras")
public class Muestra{

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDeMuestra;

    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_boya", referencedColumnName = "id_boya")
    private Boya boya;

    @Column(name = "horario")
    private Date horarioMuestra;    

    @Column(name = "matricula")
    private String matriculaDeEmbarcacion;

    @Column(name = "longitud_instalacion")
    private double longitud;

    @Column(name = "latitud_instalacion")
    private double latitud;
    
    @Column(name = "asnm")
    private double alturaAlNivelDelMar;

    @Column(name = "color_luz")
    private String colorLuz;




    public Muestra(Boya boya, Date horarioMuestra, String matriculaDeEmbarcacion, double longitud,
            double latitud, double alturaAlNivelDelMar, String colorLuz) {
        
        this.boya = boya;
        this.horarioMuestra = horarioMuestra;
        this.matriculaDeEmbarcacion = matriculaDeEmbarcacion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.alturaAlNivelDelMar = alturaAlNivelDelMar;
        this.colorLuz = colorLuz;
    }

    public Muestra(){

    }

    
    public Boya getBoya() {
        return boya;

    }

    public void setBoya(Boya boya) {
        this.boya = boya;
    }
    

    public Integer getIdDeMuestra() {
        return idDeMuestra;
    }

    

    public Date getHorarioMuestra() {
        return horarioMuestra;
    }

    public void setHorarioMuestra(Date horarioMuestra) {
        this.horarioMuestra = horarioMuestra;
    }

    public String getMatriculaDeEmbarcacion() {
        return matriculaDeEmbarcacion;
    }

    public void setMatriculaDeEmbarcacion(String matriculaDeEmbarcacion) {
        this.matriculaDeEmbarcacion = matriculaDeEmbarcacion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    
    public double getAlturaAlNivelDelMar() {
        return alturaAlNivelDelMar;
    }

    public void setAlturaAlNivelDelMar(double alturaAlNivelDelMar) {
        this.alturaAlNivelDelMar = alturaAlNivelDelMar;
    }
 
    public String getColorLuz() {
        return colorLuz;
    }

    public void setColorLuz(String colorLuz) {
        this.colorLuz = colorLuz;
    }

}
