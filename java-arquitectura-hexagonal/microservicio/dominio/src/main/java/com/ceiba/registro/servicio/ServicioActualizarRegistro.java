package com.ceiba.registro.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.registro.modelo.entidad.Registro;
import com.ceiba.registro.puerto.repositorio.RepositorioRegistro;

public class ServicioActualizarRegistro {


    private final RepositorioRegistro repositorioRegistro;

    public ServicioActualizarRegistro(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    public void ejecutar(Registro registro) {
        this.repositorioRegistro.actualizar(registro);
    }

}
