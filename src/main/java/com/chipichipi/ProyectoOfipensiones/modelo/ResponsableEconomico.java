package com.chipichipi.ProyectoOfipensiones.modelo;

import java.util.List;

public class ResponsableEconomico extends Usuario {
    private List<Estudiante> estudiantesACargo;

    public List<Estudiante> getEstudiantesACargo() {
        return estudiantesACargo;
    }

    public void setEstudiantesACargo(List<Estudiante> estudiantesACargo) {
        this.estudiantesACargo = estudiantesACargo;
    }

    
}
