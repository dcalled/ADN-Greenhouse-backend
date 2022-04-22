package com.ceiba.venta.servicio.testdatabuilder;

import com.ceiba.venta.modelo.entidad.Venta;

import java.time.LocalDate;

public class VentaTestDataBuilder {

    private Long id;
    private String nombre;
    private LocalDate fechaIngreso;
    private Double valorBase;
    private LocalDate fechaGerminacion;
    private LocalDate fechaPlantula;
    private LocalDate fechaMacollamiento;
    private LocalDate fechaReproduccion;

    public VentaTestDataBuilder() {
        id = 1L;
        nombre = "1234";
        fechaIngreso = LocalDate.now();
        fechaGerminacion = LocalDate.now();
        fechaPlantula = LocalDate.now();
        fechaMacollamiento = LocalDate.now();
        fechaReproduccion = LocalDate.now();
        valorBase = 12.34;
    }

    public VentaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public VentaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }


    public VentaTestDataBuilder conFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public VentaTestDataBuilder conFechaGerminacion(LocalDate fechaGerminacion) {
        this.fechaGerminacion = fechaGerminacion;
        return this;
    }

    public VentaTestDataBuilder conFechaMacollamiento(LocalDate fechaMacollamiento) {
        this.fechaMacollamiento = fechaMacollamiento;
        return this;
    }


    public VentaTestDataBuilder conFechaReproduccion(LocalDate fechaReproduccion) {
        this.fechaReproduccion = fechaReproduccion;
        return this;
    }

    public VentaTestDataBuilder conFechaPlantula(LocalDate fechaPlantula) {
        this.fechaPlantula = fechaPlantula;
        return this;
    }

    public VentaTestDataBuilder conValorBase(double valorBase) {
        this.valorBase = valorBase;
        return this;
    }



    public Venta build() {
        return new Venta(id, nombre, fechaIngreso, valorBase, fechaGerminacion, fechaPlantula, fechaMacollamiento, fechaReproduccion);
    }
}
