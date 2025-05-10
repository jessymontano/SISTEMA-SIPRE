package com.mycompany.sipre.modelo;

import java.util.Date;

public class Solicitud {
    public int folio;
    public int idTipo;
    public String tipoDocumento;
    public Date fecha;
    public String motivo;
    public int idUsuario;

    public Solicitud(int folio, int idTipo, String tipoDocumento, Date fecha, String motivo, int idUsuario) {

        this.folio = folio;
        this.fecha = fecha;
        this.idTipo = idTipo;
        this.tipoDocumento = tipoDocumento;
        this.motivo = motivo;
        this.idUsuario = idUsuario;
    }

    public Solicitud() {

    }


    public int getFolio(){
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getIdTipo() {
        return idTipo;
    }
    
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
