package com.chipichipi.ProyectoOfipensiones.repositorios;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chipichipi.ProyectoOfipensiones.modelo.Factura;

public interface FacturasRepository extends MongoRepository<Factura, Integer>{

    @Query("{}")
    Collection<Factura> darFacturas();

    @Query("{estudiante: ?0}")
    Collection<Factura> darFacturasEstudiante(int idEstudiante);
    
}
