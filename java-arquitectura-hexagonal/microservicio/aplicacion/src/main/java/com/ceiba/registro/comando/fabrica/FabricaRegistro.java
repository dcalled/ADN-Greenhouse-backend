package com.ceiba.registro.comando.fabrica;

import com.ceiba.registro.comando.ComandoRegistro;
import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaRegistro {

    public Registro crear(ComandoRegistro comandoRegistro) {
        return new Registro(
                comandoRegistro.getId(),
                comandoRegistro.getNombre(),
                comandoRegistro.getValorBase(),
                comandoRegistro.getTiempoVegetacion(),
                comandoRegistro.getFechaGerminacion()
        );
    }

}
