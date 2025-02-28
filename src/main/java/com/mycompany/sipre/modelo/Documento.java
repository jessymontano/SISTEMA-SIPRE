package com.mycompany.sipre.modelo;

import java.time.LocalDate;

public class Documento {

    private String documento;
    private String tipo;
    private String descripcion;

    public Documento(String documento, String tipo, String descripcion) {
        this.documento = documento;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
