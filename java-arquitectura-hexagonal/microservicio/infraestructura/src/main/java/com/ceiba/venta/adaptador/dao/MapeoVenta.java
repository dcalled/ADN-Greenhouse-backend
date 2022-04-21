package com.ceiba.venta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.venta.modelo.dto.DtoVenta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoVenta implements RowMapper<DtoVenta>, MapperResult {

    @Override
    public DtoVenta mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String fase = resultSet.getString("fase");
        Double precio = resultSet.getDouble("precio");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "fecha_ingreso");
        LocalDate fechaVenta = extraerLocalDate(resultSet, "fecha_venta");

        return new DtoVenta(id, nombre, precio, fase, fechaIngreso, fechaVenta);
    }

}
