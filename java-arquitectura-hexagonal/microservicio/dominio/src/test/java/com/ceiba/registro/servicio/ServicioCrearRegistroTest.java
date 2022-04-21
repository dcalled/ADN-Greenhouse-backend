package com.ceiba.registro.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.registro.puerto.repositorio.RepositorioRegistro;
import com.ceiba.registro.servicio.testdatabuilder.RegistroTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearRegistroTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando falte la fecha de germinacion")
    void deberiaLanzarUnaExepcionCuandoFalteLaFechaDeGerminacion() {
        // arrange
        RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder().conFechaGerminacion(null);
        // act - assert
        BasePrueba.assertThrows(registroTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el atributo");
    }


    @Test
    @DisplayName("Deberia Crear el registro de manera correcta")
    void deberiaCrearElRegistroDeManeraCorrecta() {
        // arrange
        Registro registro = new RegistroTestDataBuilder().build();
        RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
        Mockito.when(repositorioRegistro.crear(registro)).thenReturn(10L);
        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(repositorioRegistro);
        // act
        Long idUsuario = servicioCrearRegistro.ejecutar(registro);
        //- assert
        assertEquals(10L,idUsuario);
        Mockito.verify(repositorioRegistro, Mockito.times(1)).crear(registro);
    }
}
