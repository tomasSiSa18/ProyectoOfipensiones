package com.chipichipi.ProyectoOfipensiones.modelo;

public class Estudiante {
    private int id;
    private String nombre;
    private String tipoidentificacion;
    private String numeroidentificacion;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
