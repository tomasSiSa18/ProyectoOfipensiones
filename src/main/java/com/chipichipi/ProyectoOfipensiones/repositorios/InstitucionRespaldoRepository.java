package com.chipichipi.ProyectoOfipensiones.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chipichipi.ProyectoOfipensiones.modelo.InstitucionRespaldo;

public interface InstitucionRespaldoRepository extends MongoRepository<InstitucionRespaldo, Integer> {

    
    
}
