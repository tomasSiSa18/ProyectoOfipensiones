package com.chipichipi.ProyectoOfipensiones.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Instituciones")
public class Institucion {

    @Id
    private int id;
    private String nombre;
    private String direccion;
    private long telefono;
    private List<Integer> cronogramas;
    private List<Integer> estudiantes;
    private List<Integer> cursos;
    private int proovedorCobranza;
    private int gestorContable;
    private int jefeAdministrativo;
    private int gestorFinanciero;

    public Institucion(int idN, String nombreN, String direccionN, long telefonoN, int proovedorCobranzaN, int gestorContableN, int jefeAdministrativoN, int gestorFinancieroN) {

        this.id = idN;
        this.nombre = nombreN;
        this.direccion = direccionN;
        this.telefono = telefonoN;
        this.cronogramas = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.proovedorCobranza = proovedorCobranzaN;
        this.gestorContable = gestorContableN;
        this.gestorFinanciero = gestorFinancieroN;
        this.jefeAdministrativo = jefeAdministrativoN;

    }

    public Institucion() { }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public List<Integer> getCronogramas() {
        return cronogramas;
    }
    public void setCronogramas(List<Integer> cronogramas) {
        this.cronogramas = cronogramas;
    }
    public List<Integer> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(List<Integer> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public List<Integer> getCursos() {
        return cursos;
    }
    public void setCursos(List<Integer> cursos) {
        this.cursos = cursos;
    }
    public int getProovedorCobranza() {
        return proovedorCobranza;
    }
    public void setProovedorCobranza(int proovedorCobranza) {
        this.proovedorCobranza = proovedorCobranza;
    }
    public int getGestorContable() {
        return gestorContable;
    }
    public void setGestorContable(int gestorContable) {
        this.gestorContable = gestorContable;
    }
    public int getJefeAdministrativo() {
        return jefeAdministrativo;
    }
    public void setJefeAdministrativo(int jefeAdministrativo) {
        this.jefeAdministrativo = jefeAdministrativo;
    }
    public int getGestorFinanciero() {
        return gestorFinanciero;
    }
    public void setGestorFinanciero(int gestorFinanciero) {
        this.gestorFinanciero = gestorFinanciero;
    }

    

    
    
}
