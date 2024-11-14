package com.chipichipi.ProyectoOfipensiones.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection="Facturas")
public class Factura {

    @Id
    private int id;
    private int estudiante;
    private int institucionasociada;
    private int responsable_economico;
    private Date fechaLimitePago;
    private Date fechaInicial;
    private int[] pago;
    private int valor;

    public Factura() {}

    public Factura(int idN, int estudianteN, int institucionasociada, int responsable_economicoN, Date fechaLimiteN, Date fechaInicialN, int[] pagoN, int valorN) {

        this.id = idN;
        this.estudiante = estudianteN;
        this.institucionasociada = institucionasociada;
        this.responsable_economico = responsable_economicoN;
        this.fechaLimitePago = fechaLimiteN;
        this.fechaInicial = fechaInicialN;
        this.pago = pagoN;
        this.valor = valorN;

    }

    

    public int getId() {
        return id;
    }
    public int getEstudiante(){
        return estudiante;
    }
    public void setEstudiante(int estudianteN) {
        this.estudiante = estudianteN;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFechaLimitePago() {
        return fechaLimitePago;
    }
    public void setFechaLimitePago(Date fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }
    public Date getFechaInicial() {
        return fechaInicial;
    }
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }
    public int[] getPago() {
        return pago;
    }
    public void setPago(int[] pago) {
        this.pago = pago;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getResponsable_economico() {
        return responsable_economico;
    }

    public void setResponsable_economico(int responsable_economico) {
        this.responsable_economico = responsable_economico;
    }

    public int getInstitucionasociada() {
        return institucionasociada;
    }

    public void setInstitucionasociada(int institucionasociada) {
        this.institucionasociada = institucionasociada;
    }

    
    
}
 