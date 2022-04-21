package com.ceiba.registro.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.registro.servicio.ServicioEliminarRegistro;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarRegistro implements ManejadorComando<Long> {

    private final ServicioEliminarRegistro servicioEliminarRegistro;

    public ManejadorEliminarRegistro(ServicioEliminarRegistro servicioEliminarRegistro
    ) {
        this.servicioEliminarRegistro = servicioEliminarRegistro;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarRegistro.ejecutar(id);
    }
}
