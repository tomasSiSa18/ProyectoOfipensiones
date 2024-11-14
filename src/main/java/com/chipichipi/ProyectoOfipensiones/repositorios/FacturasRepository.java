package com.chipichipi.ProyectoOfipensiones.repositorios;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.chipichipi.ProyectoOfipensiones.modelo.Factura;

public interface FacturasRepository extends MongoRepository<Factura, Integer>{

    @Query("{}")
    Collection<Factura> darFacturas();

    @Query("{estudiante: ?0}")
    Collection<Factura> darFacturasEstudiante(int idEstudiante);

    @Query("{_id: ?0}")
    @Update("{$inc: {valor: ?1}}")
    void aplicarDescuento(Integer id_factura, int amount);

    @Query("{responsable_economico: ?0}")
    Collection<Factura> darFacturasResponsableEconomico(int responsable_economico);

    @Query("{institucionasociada: ?0}")
    Collection<Factura> darFacturasGestorContable(Integer institucion);

    
    
}
