package com.chipichipi.ProyectoOfipensiones.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chipichipi.ProyectoOfipensiones.modelo.Usuario;


public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {

    
    @Query("{'_id': ?0 }")
    Usuario darUsuarioPorId(int id);


    

    

}
