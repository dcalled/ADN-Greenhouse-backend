package com.ceiba.registro.servicio.testdatabuilder;

import com.ceiba.registro.modelo.entidad.Registro;

import java.time.LocalDate;

public class RegistroTestDataBuilder {

    private Long id;
    private String nombre;
    private Double valorBase;
    private Integer tiempoVegetacion;
    private LocalDate fechaGerminacion;

    public RegistroTestDataBuilder() {
        id = 1L;
        nombre = "1234";
        valorBase = 12.34;
        tiempoVegetacion = 12;
        fechaGerminacion = LocalDate.now();
    }

    public RegistroTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public RegistroTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public RegistroTestDataBuilder conTiempoVegetacion(int tiempoVegetacion) {
        this.tiempoVegetacion = tiempoVegetacion;
        return this;
    }

    public RegistroTestDataBuilder conValorBase(Double valorBase) {
        this.valorBase = valorBase;
        return this;
    }

    public RegistroTestDataBuilder conFechaGerminacion(LocalDate fechaGerminacion) {
        this.fechaGerminacion = fechaGerminacion;
        return this;
    }


    public Registro build() {
        return new Registro(id, nombre, valorBase, tiempoVegetacion, fechaGerminacion);
    }
}
