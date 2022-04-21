package com.ceiba.registro.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.registro.comando.ComandoRegistro;
import com.ceiba.registro.comando.fabrica.FabricaRegistro;
import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.registro.servicio.ServicioActualizarRegistro;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRegistro implements ManejadorComando<ComandoRegistro> {

    private final FabricaRegistro fabricaRegistro;
    private final ServicioActualizarRegistro servicioActualizarRegistro;

    public ManejadorActualizarRegistro(FabricaRegistro fabricaRegistro, ServicioActualizarRegistro servicioActualizarRegistro) {
        this.fabricaRegistro = fabricaRegistro;
        this.servicioActualizarRegistro = servicioActualizarRegistro;
    }

    public void ejecutar(ComandoRegistro comandoRegistro) {
        Registro registro = this.fabricaRegistro.crear(comandoRegistro);
        this.servicioActualizarRegistro.ejecutar(registro);
    }
}
