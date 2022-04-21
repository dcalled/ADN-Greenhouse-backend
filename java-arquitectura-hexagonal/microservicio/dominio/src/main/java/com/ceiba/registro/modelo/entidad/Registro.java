package com.ceiba.registro.modelo.entidad;


import lombok.Getter;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Random;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Registro {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";


    private static final int MINIMO_DE_DIAS_GERMINACION = 3;
    private static final int MAXIMO_DE_DIAS_GERMINACION = 6;
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
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);;

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
        int tiempoGerminacion = new Random()
                .ints(MINIMO_DE_DIAS_GERMINACION, MAXIMO_DE_DIAS_GERMINACION + 1)
                .findFirst()
                .getAsInt();
        fechaPlantula = fechaGerminacion.plusDays(tiempoGerminacion);
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
