package com.mycompany.sipre.modelo;

import java.util.Date;

public class Solicitud {
    public int folio;
    public String tipoDocumento;
    public Date fecha;
    public String motivo;

    public Solicitud(int folio, String tipoDocumento, Date fecha, String motivo) {

        this.folio = folio;
        this.fecha = fecha;
        this.tipoDocumento = tipoDocumento;
        this.motivo = motivo;
    }

    public Solicitud() {

    }


    public int getFolio(){
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
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
}
