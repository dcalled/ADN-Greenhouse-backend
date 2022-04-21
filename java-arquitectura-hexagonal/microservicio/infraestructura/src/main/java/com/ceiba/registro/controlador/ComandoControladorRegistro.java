package com.ceiba.registro.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.registro.comando.ComandoRegistro;
import com.ceiba.registro.comando.manejador.ManejadorActualizarRegistro;
import com.ceiba.registro.comando.manejador.ManejadorCrearRegistro;
import com.ceiba.registro.comando.manejador.ManejadorEliminarRegistro;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
@Api(tags = { "Controlador comando inventario"})
public class ComandoControladorRegistro {

    private final ManejadorCrearRegistro manejadorCrearRegistro;
	private final ManejadorEliminarRegistro manejadorEliminarRegistro;
	private final ManejadorActualizarRegistro manejadorActualizarRegistro;

    @Autowired
    public ComandoControladorRegistro(ManejadorCrearRegistro manejadorCrearRegistro,
									 ManejadorEliminarRegistro manejadorEliminarRegistro,
									 ManejadorActualizarRegistro manejadorActualizarRegistro) {
        this.manejadorCrearRegistro = manejadorCrearRegistro;
		this.manejadorEliminarRegistro = manejadorEliminarRegistro;
		this.manejadorActualizarRegistro = manejadorActualizarRegistro;
    }

    @PostMapping
    @ApiOperation("Crear Registro")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRegistro comandoRegistro) {
        return manejadorCrearRegistro.ejecutar(comandoRegistro);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Registro")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarRegistro.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Registro")
	public void actualizar(@RequestBody ComandoRegistro comandoRegistro,@PathVariable Long id) {
		comandoRegistro.setId(id);
		manejadorActualizarRegistro.ejecutar(comandoRegistro);
	}
}
