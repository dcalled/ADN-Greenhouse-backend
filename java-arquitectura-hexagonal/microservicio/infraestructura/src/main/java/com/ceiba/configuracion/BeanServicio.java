package com.ceiba.configuracion;

import com.ceiba.registro.puerto.repositorio.RepositorioRegistro;
import com.ceiba.registro.servicio.ServicioActualizarRegistro;
import com.ceiba.registro.servicio.ServicioCrearRegistro;
import com.ceiba.registro.servicio.ServicioEliminarRegistro;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.ServicioCrearVenta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    //----------------------------------------------------------------------

    @Bean
    public ServicioCrearRegistro servicioCrearRegistro(RepositorioRegistro repositorioRegistro) {
        return new ServicioCrearRegistro(repositorioRegistro);
    }

    @Bean
    public ServicioEliminarRegistro servicioEliminarRegistro(RepositorioRegistro repositorioRegistro) {
        return new ServicioEliminarRegistro(repositorioRegistro);
    }

    @Bean
    public ServicioActualizarRegistro servicioActualizarRegistro(RepositorioRegistro repositorioRegistro) {
        return new ServicioActualizarRegistro(repositorioRegistro);
    }

    //-----------------------------------------------------------------------

    @Bean
    public ServicioCrearVenta servicioCrearVenta(RepositorioVenta repositorioVenta) {
        return new ServicioCrearVenta(repositorioVenta);
    }


}
