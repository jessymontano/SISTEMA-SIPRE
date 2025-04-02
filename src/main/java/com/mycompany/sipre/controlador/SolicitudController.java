/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.sipre.modelo.Solicitud;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.*;

/**
 *
 * @author jessica
 */
public class SolicitudController {
    private final String BASE_URL = "http://localhost:8080/solicitudes";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    
    public boolean agregarSolicitud(Solicitud solicitud) throws IOException {
        String json = gson.toJson(solicitud);
        
        RequestBody body = RequestBody.create(json.getBytes());
        Request request = new Request.Builder().url(BASE_URL).post(body).build();
        
        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        }
    }
    
    public boolean cancelarSolicitud(int folio) throws IOException {
        Request request = new Request.Builder().url(BASE_URL + "/cancelar/" + folio).delete().build();
        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        }
    }
    
    public boolean actualizarSolicitud(Solicitud solicitud) throws IOException {
        String json = gson.toJson(solicitud);
        RequestBody body = RequestBody.create(json.getBytes());
        Request request = new Request.Builder().url(BASE_URL + "/actuallizar").put(body).build();
        
        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        }
    }
    
    public Solicitud obtenerSolicitud(int folio) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + folio)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                return gson.fromJson(jsonResponse, Solicitud.class);
            } else {
                throw new IOException("Solicitud no encontrada");
            }
        }
    }
    
    public List<Solicitud> obtenerSolicitudesPorTipo(String tipoDocumento) throws IOException {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/buscar/tipo/" + tipoDocumento).newBuilder().build();
        Request request = new Request.Builder().url(url).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Type tipoLista = new TypeToken<List<Solicitud>>() {
                }.getType();
                List<Solicitud> solicitudes = gson.fromJson(jsonResponse, tipoLista);

                return solicitudes; 
            } else {
                throw new IOException("Error al buscar solicitudes por tipo");
            }
        }
    }
    
    public List<Solicitud> obtenerSolicitudesPorFecha(int anio, int mes) throws IOException {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/buscar/fecha").newBuilder()
                .addQueryParameter("anio", String.valueOf(anio))
                .addQueryParameter("mes", String.valueOf(mes))
                .build();

        Request request = new Request.Builder().url(url).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Type tipoLista = new TypeToken<List<Solicitud>>() {
                }.getType();
                List<Solicitud> solicitudes = gson.fromJson(jsonResponse, tipoLista);

                return solicitudes;  
            } else {
                throw new IOException("Error al buscar solicitudes por fecha");
            }
        }
    }
    
    public List<Solicitud> obtenerTodasLasSolicitudes() throws IOException {
        Request request = new Request.Builder().url(BASE_URL).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Type tipoLista = new TypeToken<List<Solicitud>>() {
                }.getType();
                List<Solicitud> solicitudes = gson.fromJson(jsonResponse, tipoLista);
                for (Solicitud solicitud : solicitudes) {
                    System.out.println(solicitud.getTipoDocumento());
                }

                return solicitudes;  
            } else {
                throw new IOException("Error al obtener todas las solicitudes");
            }
        }
    }
}
