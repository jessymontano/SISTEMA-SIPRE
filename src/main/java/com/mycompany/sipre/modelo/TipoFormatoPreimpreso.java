package com.mycompany.sipre.modelo;

import com.google.gson.annotations.SerializedName;

public class TipoFormatoPreimpreso {

    private int iD_Tipo;

    private String nombre;

    public TipoFormatoPreimpreso() {}

    public TipoFormatoPreimpreso(int ID_Tipo, String Nombre) {
        this.iD_Tipo = ID_Tipo;
        this.nombre = Nombre;
    }

    public int getID_Tipo() {
        return iD_Tipo;
    }

    public void setID_Tipo(int ID_Tipo) {
        this.iD_Tipo = ID_Tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
}

