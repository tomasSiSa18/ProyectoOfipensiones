package com.chipichipi.ProyectoOfipensiones.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chipichipi.ProyectoOfipensiones.modelo.ResponsableEconomico;
import com.chipichipi.ProyectoOfipensiones.modelo.Usuario;

import org.bson.types.ObjectId;

public interface UsuarioRepository extends MongoRepository<Usuario, ObjectId> {

    @Query("{ '_id': ?0 }")
    ResponsableEconomico findResponsableEconomico(ObjectId id);

    

}
