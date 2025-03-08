package com.mycompany.sipre.modelo;

import java.util.Date;

public class Documento {
    private int Folio;
    private String TipoDocumento;
    private String Estatus;
    private int CantidadDocumentos;

    public Date fecha;

    public String motivo;


    public Documento(int Folio, String TipoDocumento, String Estatus, int CantidadDocumentos) {
        this.Folio = Folio;
        this.TipoDocumento = TipoDocumento;
        this.Estatus = Estatus;
        this.CantidadDocumentos = CantidadDocumentos;
    }

    public Documento() {
    }


    public int getFolio() {
        return  Folio;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }
    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getEstatus(){
        return Estatus;
    }
    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }
    public int getCantidadDocumentos(){
        return CantidadDocumentos;
    }

    public void setCantidadDocumentos(int CantidadDocumentos) {
        this.CantidadDocumentos = CantidadDocumentos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


}
