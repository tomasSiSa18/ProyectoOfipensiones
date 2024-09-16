package com.chipichipi.ProyectoOfipensiones.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Instituciones")
public class Institucion {

    @Id
    private int idInstitucion;
    
    
}
