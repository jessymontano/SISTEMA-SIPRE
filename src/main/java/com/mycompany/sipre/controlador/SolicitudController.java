/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mycompany.sipre.modelo.Solicitud;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Date;
import java.util.function.Consumer;
import okhttp3.*;

/**
 *
 * @author jessica
 */
public class SolicitudController {

    private final String BASE_URL = "http://localhost:8080/solicitudes";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new GsonBuilder()
    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss") // Esto está bien
    .create();

     public void agregarSolicitud(int folio, int idTipo, Date fecha, String motivo, int idUsuario, Consumer<Boolean> callback) {
        // Crear un objeto JSON manualmente para evitar problemas con el modelo
        String json = String.format("{\"folio\":%d,\"idTipo\":%d,\"fecha\":\"%s\",\"motivo\":\"%s\",\"idUsuario\":%d}",
                folio, idTipo, fecha.toString(), motivo, idUsuario);
        
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(json, JSON);
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

    public void cancelarSolicitud(int folio, Consumer<Boolean> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/cancelar/" + folio)
                .delete()
                .build();

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

    public void actualizarSolicitud(Solicitud solicitud, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(solicitud);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + "/actualizar")
                .put(body)
                .build();

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

    public void obtenerSolicitud(int folio, Consumer<Solicitud> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + folio)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Solicitud solicitud = gson.fromJson(responseBody.string(), Solicitud.class);
                        callback.accept(solicitud);
                    } else {
                        callback.accept(null);
                    }
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(null);
            }
        });
    }

    public void obtenerSolicitudesPorTipo(String tipoDocumento, Consumer<List<Solicitud>> callback) {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/buscar/tipo/" + tipoDocumento).newBuilder().build();
        Request request = new Request.Builder().url(url).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Type tipoLista = new TypeToken<List<Solicitud>>() {
                        }.getType();
                        List<Solicitud> solicitudes = gson.fromJson(responseBody.string(), tipoLista);
                        callback.accept(solicitudes);
                    } else {
                        callback.accept(null);
                    }
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(null);
            }
        });
    }

    public void obtenerSolicitudesPorFecha(int anio, int mes, Consumer<List<Solicitud>> callback) {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/buscar/fecha").newBuilder()
                .addQueryParameter("anio", String.valueOf(anio))
                .addQueryParameter("mes", String.valueOf(mes))
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Type tipoLista = new TypeToken<List<Solicitud>>() {
                        }.getType();
                        List<Solicitud> solicitudes = gson.fromJson(responseBody.string(), tipoLista);
                        callback.accept(solicitudes);
                    } else {
                        callback.accept(null);
                    }
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(null);
            }
        });
    }

    public void obtenerTodasLasSolicitudes(Consumer<List<Solicitud>> callback) {
        Request request = new Request.Builder().url(BASE_URL).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Type tipoLista = new TypeToken<List<Solicitud>>() {
                        }.getType();
                        List<Solicitud> solicitudes = gson.fromJson(responseBody.string(), tipoLista);
                        callback.accept(solicitudes);
                    } else {
                        callback.accept(null);
                    }
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(null);
            }
        });
    }
    
     public void obtenerIdTipoPorNombre(String nombreTipo, Consumer<Integer> callback) {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/tipo/id").newBuilder()
                .addQueryParameter("nombre", nombreTipo)
                .build();

        Request request = new Request.Builder().url(url).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        String json = responseBody.string();
                        callback.accept(gson.fromJson(json, Integer.class));
                    } else {
                        callback.accept(-1);
                    }
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(-1);
            }
        });
    }
}
