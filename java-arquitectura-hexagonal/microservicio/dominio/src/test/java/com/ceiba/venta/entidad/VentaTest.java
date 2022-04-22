package com.ceiba.venta.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.servicio.testdatabuilder.VentaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VentaTest {

    @Test
    @DisplayName("Deberia crear correctamente la venta")
    void deberiaCrearCorrectamenteLaVenta() {
        // arrange
        LocalDate fechaGerminacion = LocalDate.now().minusDays(10);
        LocalDate fechaPlantula = LocalDate.now().minusDays(2);
        LocalDate fechaMacollamiento = LocalDate.now().plusDays(8);
        LocalDate fechaReproduccion = LocalDate.now().plusDays(20);
        //act
        Venta venta = new VentaTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conFechaPlantula(fechaPlantula)
                .conFechaMacollamiento(fechaMacollamiento)
                .conFechaReproduccion(fechaReproduccion)
                .conValorBase(100)
                .conId(1L).build();
        //assert
        assertEquals(1, venta.getId());
        assertEquals("1234", venta.getNombre());
    }

    @Test
    void deberiaFallarSinNombre() {

        //Arrange
        VentaTestDataBuilder ventaTestDataBuilder = new VentaTestDataBuilder()
                .conNombre(null)
                .conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    ventaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el atributo");
    }


    @Test
    void deberiaCalcularFaseGerminacionCorrectamente() {
        // arrange
        LocalDate fechaGerminacion = LocalDate.now().minusDays(1);
        LocalDate fechaPlantula = LocalDate.now().plusDays(2);
        LocalDate fechaMacollamiento = LocalDate.now().plusDays(8);
        LocalDate fechaReproduccion = LocalDate.now().plusDays(20);
        //act
        Venta venta = new VentaTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conFechaPlantula(fechaPlantula)
                .conFechaMacollamiento(fechaMacollamiento)
                .conFechaReproduccion(fechaReproduccion)
                .conValorBase(100)
                .conId(1L).build();
        //assert
        assertEquals("Germinacion", venta.getFase());
        assertEquals(100*1.15, venta.getPrecio());

    }

    @Test
    void deberiaCalcularFasePlantulaCorrectamente() {
        // arrange
        LocalDate fechaGerminacion = LocalDate.now().minusDays(10);
        LocalDate fechaPlantula = LocalDate.now().minusDays(2);
        LocalDate fechaMacollamiento = LocalDate.now().plusDays(8);
        LocalDate fechaReproduccion = LocalDate.now().plusDays(20);
        //act
        Venta venta = new VentaTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conFechaPlantula(fechaPlantula)
                .conFechaMacollamiento(fechaMacollamiento)
                .conFechaReproduccion(fechaReproduccion)
                .conValorBase(100)
                .conId(1L).build();
        //assert
        assertEquals("Plantula", venta.getFase());
        assertEquals(100*1.55, venta.getPrecio());

    }

    @Test
    void deberiaCalcularFaseMacollamientoCorrectamente() {
        // arrange
        LocalDate fechaGerminacion = LocalDate.now().minusDays(10);
        LocalDate fechaPlantula = LocalDate.now().minusDays(5);
        LocalDate fechaMacollamiento = LocalDate.now().minusDays(2);
        LocalDate fechaReproduccion = LocalDate.now().plusDays(10);
        //act
        Venta venta = new VentaTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conFechaPlantula(fechaPlantula)
                .conFechaMacollamiento(fechaMacollamiento)
                .conFechaReproduccion(fechaReproduccion)
                .conValorBase(100)
                .conId(1L).build();
        //assert
        assertEquals("Macollamiento", venta.getFase());
        assertEquals(100*2, venta.getPrecio());

    }

    @Test
    void deberiaFallarVentaEnFaseReproduccion() {

        LocalDate fechaGerminacion = LocalDate.now().minusDays(15);
        LocalDate fechaPlantula = LocalDate.now().minusDays(10);
        LocalDate fechaMacollamiento = LocalDate.now().minusDays(5);
        LocalDate fechaReproduccion = LocalDate.now().minusDays(2);
        VentaTestDataBuilder ventaTestDataBuilder = new VentaTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conFechaPlantula(fechaPlantula)
                .conFechaMacollamiento(fechaMacollamiento)
                .conFechaReproduccion(fechaReproduccion)
                .conValorBase(100)
                .conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    ventaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "No se puede vender plantas en fase reproductiva.");
    }


}
