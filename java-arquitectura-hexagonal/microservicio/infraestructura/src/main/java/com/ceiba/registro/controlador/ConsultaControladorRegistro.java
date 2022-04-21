package com.ceiba.registro.controlador;

import com.ceiba.registro.consulta.ManejadorListarRegistros;
import com.ceiba.registro.consulta.ManejadorObtenerRegistro;
import com.ceiba.registro.modelo.dto.DtoRegistro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registro")
@Api(tags={"Controlador consulta ventas"})
public class ConsultaControladorRegistro {

    private final ManejadorListarRegistros manejadorListarRegistros;
    private final ManejadorObtenerRegistro manejadorObtenerRegistro;

    public ConsultaControladorRegistro(ManejadorListarRegistros manejadorListarRegistros,
                                       ManejadorObtenerRegistro manejadorObtenerRegistro) {
        this.manejadorListarRegistros = manejadorListarRegistros;
        this.manejadorObtenerRegistro = manejadorObtenerRegistro;
    }

    @GetMapping
    @ApiOperation("Listar Registros")
    public List<DtoRegistro> listar() {
        return this.manejadorListarRegistros.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Listar Registros")
    public DtoRegistro obtener(@PathVariable Long id) {
        return this.manejadorObtenerRegistro.ejecutar(id);
    }


}
