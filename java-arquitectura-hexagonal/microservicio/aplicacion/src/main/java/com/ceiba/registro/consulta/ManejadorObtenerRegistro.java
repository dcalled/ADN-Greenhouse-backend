package com.ceiba.registro.consulta;

import com.ceiba.registro.modelo.dto.DtoRegistro;
import com.ceiba.registro.puerto.dao.DaoRegistro;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerRegistro {

    private final DaoRegistro daoRegistro;

    public ManejadorObtenerRegistro(DaoRegistro daoRegistro){
        this.daoRegistro = daoRegistro;
    }

    public DtoRegistro ejecutar(Long id){ return this.daoRegistro.obtener(id); }
}
