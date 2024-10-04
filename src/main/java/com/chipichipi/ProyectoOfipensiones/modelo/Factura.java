package com.chipichipi.ProyectoOfipensiones.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection="Facturas")
public class Factura {

    @Id
    private int id;
    private Date fechaLimitePago;
    private Date fechaInicial;
    private int[] pago;
    private int valor;

    public Factura() {}

    public Factura(int idN, Date fechaLimiteN, Date fechaInicialN, int[] pagoN, int valorN) {

        this.id = idN;
        this.fechaLimitePago = fechaLimiteN;
        this.fechaInicial = fechaInicialN;
        this.pago = pagoN;
        this.valor = valorN;

    }

    public int getId() {
        return id;
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

    
    
}
 