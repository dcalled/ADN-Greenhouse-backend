package com.ceiba.registro.modelo.entidad;


import lombok.Getter;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Random;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Registro {

    private static final String ATRIBUTO_OBLIGATORIO = "Se debe ingresar el atributo";


    private static final int DIAS_GERMINACION = 4;
    private static final double PORCENTAJE_TIEMPO_DE_PLANTULA = 0.2;

    private Long id;
    private String nombre;
    private Double valorBase;
    private Integer tiempoVegetacion;
    private LocalDate fechaIngreso;
    private LocalDate fechaGerminacion;
    private LocalDate fechaPlantula;
    private LocalDate fechaMacollamiento;
    private LocalDate fechaReproduccion;

    public Registro(Long id, String nombre, Double valorBase, Integer tiempoVegetacion, LocalDate fechaGerminacion) {
        validarObligatorio(nombre, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(valorBase, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(tiempoVegetacion, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(fechaGerminacion, ATRIBUTO_OBLIGATORIO);

        this.id = id;
        this.nombre = nombre;
        this.valorBase = valorBase;
        this.tiempoVegetacion = tiempoVegetacion;
        this.fechaIngreso = LocalDate.now();
        this.fechaGerminacion = fechaGerminacion;
        calcularFechaPlantula();
        calcularFechaMacollamiento();
        calcularFechaReproduccion();
    }

    private void calcularFechaPlantula() {
        fechaPlantula = fechaGerminacion.plusDays(DIAS_GERMINACION);
    }

    private void calcularFechaMacollamiento() {
        int tiempoPlantula = (int) (tiempoVegetacion * PORCENTAJE_TIEMPO_DE_PLANTULA);
        fechaMacollamiento = fechaPlantula.plusDays(tiempoPlantula);
    }

    private void calcularFechaReproduccion() {
        int tiempoMacollaje = tiempoVegetacion - (int) (tiempoVegetacion * PORCENTAJE_TIEMPO_DE_PLANTULA);
        fechaReproduccion = fechaMacollamiento.plusDays(tiempoMacollaje);
    }

}
