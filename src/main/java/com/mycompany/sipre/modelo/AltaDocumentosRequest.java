/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.modelo;

/**
 *
 * @author jessica
 */
public class AltaDocumentosRequest {

    private String tipoDocumento;
    private int cantidad;
    private int folioInicial;
    private int folioFinal;
    private String fechaIngreso;
    private int idUsuario;

    public AltaDocumentosRequest() {

    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getFolioInicial() {
        return folioInicial;
    }

    public void setFolioInicial(int folioInicial) {
        this.folioInicial = folioInicial;
    }

    public int getFolioFinal() {
        return folioFinal;
    }

    public void setFolioFinal(int folioFinal) {
        this.folioFinal = folioFinal;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
