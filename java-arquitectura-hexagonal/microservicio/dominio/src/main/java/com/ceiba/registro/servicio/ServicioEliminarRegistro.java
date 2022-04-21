package com.ceiba.registro.servicio;

import com.ceiba.registro.puerto.repositorio.RepositorioRegistro;

public class ServicioEliminarRegistro {

    private final RepositorioRegistro repositorioRegistro;

    public ServicioEliminarRegistro(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    public void ejecutar(Long id) {
        this.repositorioRegistro.eliminar(id);
    }
}
