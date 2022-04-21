package com.ceiba.venta.puerto.repositorio;

import com.ceiba.venta.modelo.entidad.Venta;

public interface RepositorioVenta {
    /**
     * Permite crear un registro
     * @param venta
     * @return el id generado
     */
    Long crear(Venta venta);

    /**
     * Permite validar si existe un registro con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
