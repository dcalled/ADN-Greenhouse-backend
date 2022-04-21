package com.ceiba.registro.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.registro.modelo.dto.DtoRegistro;
import com.ceiba.registro.puerto.dao.DaoRegistro;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class DaoRegistroMysql implements DaoRegistro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="registro", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="registro", value="obtener")
    private static String sqlObtener;

    public DaoRegistroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRegistro> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRegistro());
    }

    @Override
    public Optional<DtoRegistro> obtener(Long id) {
        Map<String, Long> parametro = new HashMap<>();
        parametro.put("id", id);
        try {
            DtoRegistro registro = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, parametro, new MapeoRegistro());
            return Optional.ofNullable(registro);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
