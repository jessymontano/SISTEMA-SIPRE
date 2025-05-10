package com.mycompany.sipre.modelo;

import java.util.Date;

public class Documento {
     private int folio;
    private String tipoDocumento; // For display/UI
    private int idTipo;          // For database operations
    private String estatus;

    public Documento(int Folio, String TipoDocumento, String Estatus) {
        this.folio = Folio;
        this.tipoDocumento = TipoDocumento;
        this.estatus = Estatus;
    }

    public Documento() {
    }


    public int getFolio() {
        return  folio;
    }

    public void setFolio(int Folio) {
        this.folio = Folio;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String TipoDocumento) {
        this.tipoDocumento = TipoDocumento;
    }

    public String getEstatus(){
        return estatus;
    }
    public void setEstatus(String Estatus) {
        this.estatus = Estatus;
    }

    public void setIdTipo(int id) {
        this.idTipo = id;
    }
    
    public int getIdTipo() {
        return idTipo;
    }

}
