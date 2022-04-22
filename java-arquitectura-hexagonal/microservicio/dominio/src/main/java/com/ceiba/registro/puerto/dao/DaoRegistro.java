package com.ceiba.registro.puerto.dao;

import com.ceiba.registro.modelo.dto.DtoRegistro;

import java.util.List;

public interface DaoRegistro {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoRegistro> listar();

    /**
     * Permite obtener un usuario
     * @param id
     * @return los usuarios
     */
    DtoRegistro obtener(Long id);
}
