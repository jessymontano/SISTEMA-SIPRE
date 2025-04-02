/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sipre.controlador;

import com.google.gson.Gson;
import com.mycompany.sipre.modelo.Usuario;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import okhttp3.*;

/**
 *
 * @author jessica
 */
public class UsuarioController {

    private final String BASE_URL = "http://localhost:8080/usuarios";
    private final OkHttpClient client = new OkHttpClient();

    public boolean crearUsuario(Usuario usuario) throws IOException {
        String json = "{"
                + "\"nombre\": \"" + usuario.getNombre() + "\","
                + "\"apellido\": \"" + usuario.getApellido() + "\","
                + "\"email\": \"" + usuario.getEmail() + "\","
                + "\"contrasena\": \"" + usuario.getContrasena() + "\","
                + "\"rol\": \"" + usuario.getRol() + "\""
                + "}";

        RequestBody body = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(BASE_URL + "/registrar").post(body).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return true;
            }
            return false;
        }

    }

    public boolean autenticar(String nombre, String contrasena) throws IOException {
        HttpUrl url = HttpUrl.parse(BASE_URL + "/login").newBuilder().addQueryParameter("nombre", nombre).addQueryParameter("contrasena", contrasena).build();

        Request request = new Request.Builder().url(url).post(RequestBody.create(new byte[0])).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return true;
            }
            return false;
        }
    }

    public Usuario getUsuario(String nombreUsuario) throws IOException {
        Request request = new Request.Builder().url(BASE_URL + "/" + nombreUsuario).get().build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Gson gson = new Gson();
                Usuario usuario = gson.fromJson(jsonResponse, Usuario.class);

                return usuario;
            } else {
                throw new IOException("Error al obtener usuario: " + response.message());
            }
        }
    }
}
