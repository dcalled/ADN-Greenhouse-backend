package com.ceiba.registro.servicio;

import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.registro.puerto.repositorio.RepositorioRegistro;
import com.ceiba.registro.servicio.testdatabuilder.RegistroTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarRegistroTest {


    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Registro registro = new RegistroTestDataBuilder().conId(1L).build();
        RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
        Mockito.when(repositorioRegistro.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarRegistro servicioActualizarRegistro = new ServicioActualizarRegistro(repositorioRegistro);
        // act
        servicioActualizarRegistro.ejecutar(registro);
        //assert
        Mockito.verify(repositorioRegistro,Mockito.times(1)).actualizar(registro);
    }
}
