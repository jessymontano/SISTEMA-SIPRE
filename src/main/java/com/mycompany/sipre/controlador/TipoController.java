package com.mycompany.sipre.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.sipre.modelo.TipoFormatoPreimpreso;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Consumer;

public class TipoController {
    private final String BASE_URL = "http://localhost:8080/tipos";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    // Método para agregar un nuevo tipo
    public void agregarTipo(TipoFormatoPreimpreso tipo, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(tipo);
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

    // Método para obtener todos los tipos
    public void obtenerTipos(Consumer<List<TipoFormatoPreimpreso>> callback) {
        Request request = new Request.Builder().url(BASE_URL).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful() || responseBody == null) {
                        callback.accept(null);
                        return;
                    }
                    String json = responseBody.string();
                    Type tipoLista = new TypeToken<List<TipoFormatoPreimpreso>>() {}.getType();
                    List<TipoFormatoPreimpreso> tipos = gson.fromJson(json, tipoLista);
                    callback.accept(tipos);
                } catch (Exception e) {
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

    // Método para eliminar un tipo
    public void eliminarTipo(int idTipo, Consumer<Boolean> callback) {
        Request request = new Request.Builder().url(BASE_URL + "/" + idTipo).delete().build();

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

    public void actualizarTipo(int idTipo, TipoFormatoPreimpreso tipo, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(tipo);

        // Imprimir el JSON antes de enviarlo
        System.out.println("JSON que se está enviando: " + json);

        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(BASE_URL + "/" + idTipo)
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
}
