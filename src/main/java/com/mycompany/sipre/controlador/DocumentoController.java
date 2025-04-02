/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.sipre.modelo.Documento;
import okhttp3.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author jessica
 */
public class DocumentoController {

    private final String BASE_URL = "http://localhost:8080/documentos";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public boolean agregarDocumento(Documento documento) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(documento);

        RequestBody body = RequestBody.create(json.getBytes());

        Request request = new Request.Builder().url(BASE_URL).post(body).build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        }
    }

    public List<Documento> obtenerTodosLosDocumentos() throws IOException {
        Request request = new Request.Builder().url(BASE_URL).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Type tipoLista = new TypeToken<List<Documento>>() {
                }.getType();
                List<Documento> documentos = gson.fromJson(jsonResponse, tipoLista);

                return documentos;
            } else {
                throw new IOException("Error al obtener los documentos");
            }
        }
    }

    public Documento obtenerDocumentoPorFolio(int folio) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + folio)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                return gson.fromJson(jsonResponse, Documento.class);
            } else {
                throw new IOException("Documento no encontrado");
            }
        }
    }

    public List<Documento> obtenerDocumentosPorEstatus(String estatus) throws IOException {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/estatus/" + estatus).newBuilder().build();
        Request request = new Request.Builder().url(url).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Type tipoLista = new TypeToken<List<Documento>>() {
                }.getType();
                List<Documento> documentos = gson.fromJson(jsonResponse, tipoLista);

                return documentos;
            } else {
                throw new IOException("Error al buscar documentos por estatus");
            }
        }
    }

    public List<Documento> obtenerDocumentosPorTipo(String tipo) throws IOException {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/tipo/" + tipo).newBuilder().build();
        Request request = new Request.Builder().url(url).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Type tipoLista = new TypeToken<List<Documento>>() {
                }.getType();
                List<Documento> documentos = gson.fromJson(jsonResponse, tipoLista);

                return documentos;
            } else {
                throw new IOException("Error al buscar documentos por tipo");
            }
        }
    }

    public boolean actualizarDocumento(int folio, Documento documento) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(documento);

        RequestBody body = RequestBody.create(json.getBytes());

        Request request = new Request.Builder()
                .url(BASE_URL + "/" + folio)
                .put(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        }
    }

    // Método para eliminar documento
    public boolean eliminarDocumento(int folio) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + folio)
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        }
    }
}
