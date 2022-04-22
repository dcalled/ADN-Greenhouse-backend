package com.ceiba.registro.servicio;

import com.ceiba.registro.puerto.repositorio.RepositorioRegistro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarRegistroTest {

    @Test
    @DisplayName("Deberia eliminar el registro llamando al repositorio")
    void deberiaEliminarElRegistroLlamandoAlRepositorio() {
        RepositorioRegistro repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
        ServicioEliminarRegistro servicioEliminarRegistro = new ServicioEliminarRegistro(repositorioRegistro);

        servicioEliminarRegistro.ejecutar(1L);

        Mockito.verify(repositorioRegistro, Mockito.times(1)).eliminar(1L);

    }

}
