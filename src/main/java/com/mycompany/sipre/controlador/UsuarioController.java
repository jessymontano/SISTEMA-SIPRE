/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.sipre.modelo.Usuario;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Consumer;
import okhttp3.*;

import javax.swing.*;

/**
 *
 * @author jessica
 */
public class UsuarioController {

    private final String BASE_URL = "http://localhost:8080/usuarios";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public void obtenerTodosLosUsuarios(Consumer<List<Usuario>> callback) {
        Request request = new Request.Builder().url(BASE_URL).get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Type tipoLista = new TypeToken<List<Usuario>>() {
                        }.getType();
                        List<Usuario> usuarios = gson.fromJson(responseBody.string(), tipoLista);
                        callback.accept(usuarios);
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

    public void crearUsuario(Usuario usuario, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(usuario);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + "/registrar")
                .post(body)
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

    public void autenticar(String nombre, String contrasena, Consumer<Boolean> callback) {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/login").newBuilder()
                .addQueryParameter("nombre", nombre)
                .addQueryParameter("contrasena", contrasena)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(new byte[0]))
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

    public void getUsuario(String nombreUsuario, Consumer<Usuario> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + nombreUsuario)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Usuario usuario = gson.fromJson(responseBody.string(), Usuario.class);
                        callback.accept(usuario);
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

    public void eliminarUsuario(int idUsuario, Consumer<Boolean> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + idUsuario)
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

    public void modificarUsuario(int idUsuario, Usuario usuario, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(usuario);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + idUsuario)
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

    public void modificarRolDeUsuario(int idUsuario, String nuevoRol, Consumer<Boolean> callback) {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/" + idUsuario + "/rol")
                .newBuilder()
                .addQueryParameter("nuevoRol", nuevoRol)
                .build();
        
        RequestBody body = RequestBody.create("", null);
        Request request = new Request.Builder()
                .url(url) //
                .put(body) //
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
