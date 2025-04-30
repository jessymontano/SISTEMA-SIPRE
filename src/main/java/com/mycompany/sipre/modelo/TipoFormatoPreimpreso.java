package com.mycompany.sipre.modelo;

import com.google.gson.annotations.SerializedName;

public class TipoFormatoPreimpreso {
    public int idTipo;
    public String nombre;

    public TipoFormatoPreimpreso(int idTipo, String nombre) {

        this.idTipo = idTipo;
        this.nombre = nombre;
    }

    public TipoFormatoPreimpreso() {

    }
    public int getIdTipo(){
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}

