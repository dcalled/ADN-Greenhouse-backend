package com.ceiba.venta.servicio.testdatabuilder;

import com.ceiba.venta.comando.ComandoVenta;

public class ComandoVentaTestDataBuilder {

    private Long id;

    public ComandoVentaTestDataBuilder() {
        id = 1L;
    }

    public ComandoVentaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoVenta build() {
        return new ComandoVenta(id);
    }
}
