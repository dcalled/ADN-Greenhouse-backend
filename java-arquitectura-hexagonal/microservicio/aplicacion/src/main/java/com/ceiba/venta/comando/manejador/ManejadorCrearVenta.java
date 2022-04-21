package com.ceiba.venta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.registro.modelo.dto.DtoRegistro;
import com.ceiba.registro.puerto.dao.DaoRegistro;
import com.ceiba.venta.comando.ComandoVenta;
import com.ceiba.venta.comando.fabrica.FabricaVenta;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.servicio.ServicioCrearVenta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearVenta implements ManejadorComandoRespuesta<ComandoVenta, ComandoRespuesta<Long>> {

    private final FabricaVenta fabricaVenta;
    private final ServicioCrearVenta servicioCrearVenta;
    private final DaoRegistro daoRegistro;

    public ManejadorCrearVenta(FabricaVenta fabricaVenta, ServicioCrearVenta servicioCrearVenta, DaoRegistro daoRegistro) {
        this.fabricaVenta = fabricaVenta;
        this.servicioCrearVenta = servicioCrearVenta;
        this.daoRegistro = daoRegistro;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoVenta comandoVenta) {
        DtoRegistro registro = daoRegistro.obtener(comandoVenta.getId()).get();
        Venta venta = fabricaVenta.crear(registro);
        return new ComandoRespuesta<>(this.servicioCrearVenta.ejecutar(venta));
    }
}
