package com.ceiba.registro.servicio;

import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.registro.puerto.repositorio.RepositorioRegistro;


public class ServicioCrearRegistro {
    
    private final RepositorioRegistro repositorioRegistro;

    public ServicioCrearRegistro(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    public Long ejecutar(Registro registro) {
        return this.repositorioRegistro.crear(registro);
    }

}
