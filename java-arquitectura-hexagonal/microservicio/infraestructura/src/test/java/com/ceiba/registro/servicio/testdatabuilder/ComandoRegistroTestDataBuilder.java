package com.ceiba.registro.servicio.testdatabuilder;

import com.ceiba.registro.comando.ComandoRegistro;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoRegistroTestDataBuilder {

    private Long id;
    private String nombre;
    private Double valorBase;
    private Integer tiempoVegetacion;
    private LocalDate fechaGerminacion;

    public ComandoRegistroTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        valorBase = 12.34;
        tiempoVegetacion = 56;
        fechaGerminacion = LocalDate.now();
    }

    public ComandoRegistroTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoRegistroTestDataBuilder conValorBase(Double valorBase) {
        this.valorBase = valorBase;
        return this;
    }

    public ComandoRegistroTestDataBuilder conTiempoVegetacion(int tiempoVegetacion) {
        this.tiempoVegetacion = tiempoVegetacion;
        return this;
    }

    public ComandoRegistroTestDataBuilder conFechaGerminacion(LocalDate fechaGerminacion) {
        this.fechaGerminacion = fechaGerminacion;
        return this;
    }

    public ComandoRegistroTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoRegistro build() {
        return new ComandoRegistro(id,nombre, valorBase,tiempoVegetacion, fechaGerminacion);
    }
}
