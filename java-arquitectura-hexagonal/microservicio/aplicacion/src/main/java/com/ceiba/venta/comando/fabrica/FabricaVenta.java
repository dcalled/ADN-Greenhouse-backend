package com.ceiba.venta.comando.fabrica;

import com.ceiba.registro.modelo.dto.DtoRegistro;
import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.venta.comando.ComandoVenta;
import com.ceiba.venta.modelo.entidad.Venta;
import org.springframework.stereotype.Component;

@Component
public class FabricaVenta {

    public Venta crear(DtoRegistro registro) {
        return new Venta(registro);
    }


}
