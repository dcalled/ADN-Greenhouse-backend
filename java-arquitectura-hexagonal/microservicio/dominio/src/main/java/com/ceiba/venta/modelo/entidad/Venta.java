package com.ceiba.venta.modelo.entidad;


import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.registro.modelo.dto.DtoRegistro;
import com.ceiba.registro.modelo.entidad.Registro;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Random;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Venta {

    private static final String ATRIBUTO_OBLIGATORIO = "Se debe ingresar el atributo";

    private static final Double AUMENTO_PRECIO_EN_MACOLLAMIENTO = 2.;
    private static final Double AUMENTO_PRECIO_EN_PLANTULA = 1.55;
    private static final Double AUMENTO_PRECIO_EN_GERMINACION = 1.15;

    private static final String FASE_MACOLLAMIENTO = "Macollamiento";
    private static final String FASE_PLANTULA = "Plantula";
    private static final String FASE_GERMINACION = "Germinacion";


    private Long id;
    private String nombre;
    private Double precio;
    private String fase;
    private LocalDate fechaIngreso;
    private LocalDate fechaVenta;


    public Venta(DtoRegistro registro) {
        this(null,
                registro.getNombre(),
                registro.getFechaIngreso(),
                registro.getValorBase(),
                registro.getFechaGerminacion(),
                registro.getFechaPlantula(),
                registro.getFechaMacollamiento(),
                registro.getFechaReproduccion()
        );

    }

    public Venta(Long id, String nombre, LocalDate fechaIngreso, Double valorBase,
                 LocalDate fechaGerminacion, LocalDate fechaPlantula,
                 LocalDate fechaMacollamiento, LocalDate fechaReproduccion) {
        validarObligatorio(nombre, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(fechaIngreso, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(valorBase, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(fechaGerminacion, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(fechaPlantula, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(fechaMacollamiento, ATRIBUTO_OBLIGATORIO);
        validarObligatorio(fechaReproduccion, ATRIBUTO_OBLIGATORIO);
        this.id = id;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.fechaVenta = LocalDate.now();
        calcularPrecioYFase(valorBase,fechaGerminacion, fechaPlantula, fechaMacollamiento, fechaReproduccion);
    }

    private void calcularPrecioYFase(Double valorBase, LocalDate fechaGerminacion, LocalDate fechaPlantula,
                                LocalDate fechaMacollamiento, LocalDate fechaReproduccion) {

            double aumentoPrecio = 0.;
            if (fechaVenta.isAfter(fechaReproduccion)) {
                throw new ExcepcionValorInvalido("No se puede vender plantas en fase reproductiva.");
            } else if (fechaVenta.isAfter(fechaMacollamiento)) {
                aumentoPrecio = AUMENTO_PRECIO_EN_MACOLLAMIENTO;
                fase = FASE_MACOLLAMIENTO;
            } else if (fechaVenta.isAfter(fechaPlantula)) {
                aumentoPrecio = AUMENTO_PRECIO_EN_PLANTULA;
                fase = FASE_PLANTULA;
            } else if (fechaVenta.isAfter(fechaGerminacion)) {
                aumentoPrecio = AUMENTO_PRECIO_EN_GERMINACION;
                fase = FASE_GERMINACION;
            } else throw new ExcepcionValorInvalido("No se venden semillas.");

            precio = valorBase * aumentoPrecio;

    }


}
