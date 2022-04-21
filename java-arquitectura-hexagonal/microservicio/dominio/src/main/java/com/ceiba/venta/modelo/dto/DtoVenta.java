package com.ceiba.venta.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoVenta {
    private Long id;
    private String nombre;
    private Double precio;
    private String fase;
    private LocalDate fechaIngreso;
    private LocalDate fechaVenta;
}
