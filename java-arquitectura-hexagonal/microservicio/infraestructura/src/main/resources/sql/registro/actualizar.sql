update inventario
set nombre = :nombre,
    valor_base = :valorBase,
    tiempo_vegetacion = :tiempoVegetacion,
    fecha_ingreso = :fechaIngreso,
    fecha_germinacion = :fechaGerminacion,
    fecha_plantula = :fechaPlantula,
    fecha_macollamiento = :fechaMacollamiento,
    fecha_reproduccion = :fechaReproduccion
where id = :id