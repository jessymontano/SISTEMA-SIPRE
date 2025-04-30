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
import java.util.function.Consumer;

/**
 *
 * @author jessica
 */
public class DocumentoController {

    private final String BASE_URL = "http://localhost:8080/documentos";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

   public void agregarDocumento(Documento documento, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(documento);
        RequestBody body = RequestBody.create(json.getBytes());
        Request request = new Request.Builder().url(BASE_URL).post(body).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.accept(response.isSuccessful());
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(false);
            }
        });
    }

    public void obtenerTodosLosDocumentos(Consumer<List<Documento>> callback) {
        Request request = new Request.Builder().url(BASE_URL).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                if (!response.isSuccessful() || response.body() == null) {   
                    callback.accept(null);
                }
                String json = responseBody.string();
                System.out.println("JSON recibido: " + json); // Debug opcional

                Type tipoLista = new TypeToken<List<Documento>>() {}.getType();
                List<Documento> documentos = gson.fromJson(json, tipoLista);
                callback.accept(documentos);
                } catch (Exception e ) {
                    e.printStackTrace();
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(null);
            }
        });
    }

     public void obtenerDocumentoPorFolio(int folio, Consumer<Documento> callback) {
        Request request = new Request.Builder().url(BASE_URL + "/" + folio).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    Documento documento = gson.fromJson(response.body().string(), Documento.class);
                    callback.accept(documento);
                } else {
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(null);
            }
        });
    }

    public void obtenerDocumentosPorEstatus(String estatus, Consumer<List<Documento>> callback) {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/estatus/" + estatus).newBuilder().build();
        Request request = new Request.Builder().url(url).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    Type tipoLista = new TypeToken<List<Documento>>() {}.getType();
                    List<Documento> documentos = gson.fromJson(response.body().string(), tipoLista);
                    callback.accept(documentos);
                } else {
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(null);
            }
        });
    }

    public void obtenerDocumentosPorTipo(String tipo, Consumer<List<Documento>> callback) {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/tipo/" + tipo).newBuilder().build();
        Request request = new Request.Builder().url(url).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    Type tipoLista = new TypeToken<List<Documento>>() {}.getType();
                    List<Documento> documentos = gson.fromJson(response.body().string(), tipoLista);
                    callback.accept(documentos);
                } else {
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(null);
            }
        });
    }

    public void actualizarDocumento(int folio, Documento documento, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(documento);
        RequestBody body = RequestBody.create(json.getBytes());

        Request request = new Request.Builder().url(BASE_URL + "/" + folio).put(body).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.accept(response.isSuccessful());
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(false);
            }
        });
    }

    // Método para eliminar documento
    public void eliminarDocumento(int folio, Consumer<Boolean> callback) {
        Request request = new Request.Builder().url(BASE_URL + "/" + folio).delete().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.accept(response.isSuccessful());
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(false);
            }
        });
    }
}
