package com.ceiba.registro.consulta;

import com.ceiba.registro.modelo.dto.DtoRegistro;
import com.ceiba.registro.puerto.dao.DaoRegistro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarRegistros {

    private final DaoRegistro daoRegistro;

    public ManejadorListarRegistros(DaoRegistro daoRegistro){
        this.daoRegistro = daoRegistro;
    }

    public List<DtoRegistro> ejecutar(){ return this.daoRegistro.listar(); }
}
