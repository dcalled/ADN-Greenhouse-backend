package com.ceiba.registro.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.registro.servicio.testdatabuilder.RegistroTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistroTest {

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElRegistro() {
        // arrange
        LocalDate fechaGerminacion = LocalDate.now();
        //act
        Registro registro = new RegistroTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conId(1L).build();
        //assert
        assertEquals(1, registro.getId());
        assertEquals("1234", registro.getNombre());
        assertEquals(12.34, registro.getValorBase());
        assertEquals(fechaGerminacion, registro.getFechaGerminacion());
    }

    @Test
    void deberiaFallarSinNombre() {

        //Arrange
        RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder()
                .conNombre(null)
                .conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    registroTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el atributo");
    }


    @Test
    void deberiaCalcularFechaPlantulaCorrectamente() {
        int tiempoVegetacion = 100;
        LocalDate fechaGerminacion = LocalDate.of(2022, 3,20);
        LocalDate fechaPlantula = LocalDate.of(2022, 3, 24);

        Registro registro = new RegistroTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conTiempoVegetacion(tiempoVegetacion)
                .build();

        assertEquals(fechaPlantula, registro.getFechaPlantula());

    }

    @Test
    void deberiaCalcularFechaReproduccionCorrectamente() {
        int tiempoVegetacion = 100;
        LocalDate fechaGerminacion = LocalDate.of(2022, 3,20);
        LocalDate fechaReproduccion = LocalDate.of(2022, 7, 2);

        Registro registro = new RegistroTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conTiempoVegetacion(tiempoVegetacion)
                .build();

        assertEquals(fechaReproduccion, registro.getFechaReproduccion());

    }


    @Test
    void deberiaCalcularFechaMacollamientoCorrectamente() {
        int tiempoVegetacion = 100;
        LocalDate fechaGerminacion = LocalDate.of(2022, 3,20);
        LocalDate fechaMacollamiento = LocalDate.of(2022, 4, 13);

        Registro registro = new RegistroTestDataBuilder()
                .conFechaGerminacion(fechaGerminacion)
                .conTiempoVegetacion(tiempoVegetacion)
                .build();

        assertEquals(fechaMacollamiento, registro.getFechaMacollamiento());

    }
}
