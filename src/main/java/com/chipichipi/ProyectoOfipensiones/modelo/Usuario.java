package com.chipichipi.ProyectoOfipensiones.modelo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    private ObjectId id;  
    private String nombre;
    private String tipoidentificacion;
    private String numeroidentificacion;
    private int institucionasociada;
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoidentificacion() {
        return tipoidentificacion;
    }
    public void setTipoidentificacion(String tipoidentificacion) {
        this.tipoidentificacion = tipoidentificacion;
    }
    public String getNumeroidentificacion() {
        return numeroidentificacion;
    }
    public void setNumeroidentificacion(String numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }
    public int getInstitucionasociada() {
        return institucionasociada;
    }
    public void setInstitucionasociada(int institucionasociada) {
        this.institucionasociada = institucionasociada;
    }
    





    
}
