package com.ceiba.registro.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.registro.modelo.dto.DtoRegistro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoRegistro implements RowMapper<DtoRegistro>, MapperResult {

    @Override
    public DtoRegistro mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        Double valorBase = resultSet.getDouble("valor_base");
        Integer tiempoVegetacion = resultSet.getInt("tiempo_vegetacion");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "fecha_ingreso");
        LocalDate fechaGerminacion = extraerLocalDate(resultSet, "fecha_germinacion");
        LocalDate fechaPlantula = extraerLocalDate(resultSet, "fecha_plantula");
        LocalDate fechaMacollamiento = extraerLocalDate(resultSet, "fecha_macollamiento");
        LocalDate fechaReproduccion = extraerLocalDate(resultSet, "fecha_reproduccion");

        return new DtoRegistro(id, nombre, valorBase, tiempoVegetacion, fechaIngreso, fechaGerminacion, fechaPlantula, fechaMacollamiento, fechaReproduccion);
    }

}
