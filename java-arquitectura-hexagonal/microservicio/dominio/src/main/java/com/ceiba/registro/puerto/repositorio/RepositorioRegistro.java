package com.ceiba.registro.puerto.repositorio;

import com.ceiba.registro.modelo.entidad.Registro;

public interface RepositorioRegistro {
    /**
     * Permite crear un registro
     * @param registro
     * @return el id generado
     */
    Long crear(Registro registro);

    /**
     * Permite actualizar un registro
     * @param registro
     */
    void actualizar(Registro registro);

    /**
     * Permite eliminar un registro
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un registro con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
