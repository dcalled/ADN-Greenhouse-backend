package com.ceiba.registro.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoRegistro {
    private Long id;
    private String nombre;
    private Double valorBase;
    private Integer tiempoVegetacion;
    private LocalDate fechaIngreso;
    private LocalDate fechaGerminacion;
    private LocalDate fechaPlantula;
    private LocalDate fechaMacollamiento;
    private LocalDate fechaReproduccion;
}
