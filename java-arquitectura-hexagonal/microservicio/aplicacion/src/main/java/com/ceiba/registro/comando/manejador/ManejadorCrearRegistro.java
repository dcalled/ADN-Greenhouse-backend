package com.ceiba.registro.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.registro.comando.ComandoRegistro;
import com.ceiba.registro.comando.fabrica.FabricaRegistro;
import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.registro.servicio.ServicioCrearRegistro;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRegistro implements ManejadorComandoRespuesta<ComandoRegistro, ComandoRespuesta<Long>> {

    private final FabricaRegistro fabricaRegistro;
    private final ServicioCrearRegistro servicioCrearRegistro;

    public ManejadorCrearRegistro(FabricaRegistro fabricaRegistro, ServicioCrearRegistro servicioCrearRegistro) {
        this.fabricaRegistro = fabricaRegistro;
        this.servicioCrearRegistro = servicioCrearRegistro;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRegistro comandoRegistro) {
        Registro registro = this.fabricaRegistro.crear(comandoRegistro);
        return new ComandoRespuesta<>(this.servicioCrearRegistro.ejecutar(registro));
    }
}
