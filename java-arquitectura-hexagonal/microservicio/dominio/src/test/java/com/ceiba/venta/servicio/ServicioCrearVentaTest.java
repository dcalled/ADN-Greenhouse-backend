package com.ceiba.venta.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.testdatabuilder.VentaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearVentaTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando falte la fecha de germinacion")
    void deberiaLanzarUnaExepcionCuandoFalteLaFechaDeGerminacion() {
        // arrange
        VentaTestDataBuilder registroTestDataBuilder = new VentaTestDataBuilder().conFechaGerminacion(null);
        // act - assert
        BasePrueba.assertThrows(registroTestDataBuilder::build, ExcepcionValorInvalido.class, "Valor invalido");
    }


    @Test
    @DisplayName("Deberia Crear la venta de manera correcta")
    void deberiaCrearLaVentaDeManeraCorrecta() {
        // arrange
        Venta venta = new VentaTestDataBuilder()
                .conFechaReproduccion(LocalDate.now().plusDays(10))
                .conFechaMacollamiento(LocalDate.now().minusDays(10))
                .build();
        RepositorioVenta repositorioVenta = Mockito.mock(RepositorioVenta.class);
        Mockito.when(repositorioVenta.crear(venta)).thenReturn(10L);
        ServicioCrearVenta servicioCrearVenta = new ServicioCrearVenta(repositorioVenta);
        // act
        Long id = servicioCrearVenta.ejecutar(venta);
        //- assert
        assertEquals(10L,id);
        Mockito.verify(repositorioVenta, Mockito.times(1)).crear(venta);
    }
}
