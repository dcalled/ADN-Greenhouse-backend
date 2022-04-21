package com.ceiba.venta.puerto.dao;

import com.ceiba.venta.modelo.dto.DtoVenta;

import java.util.List;

public interface DaoVenta {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoVenta> listar();
}
