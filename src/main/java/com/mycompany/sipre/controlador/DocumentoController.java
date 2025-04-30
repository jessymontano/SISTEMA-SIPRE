package com.mycompany.sipre.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.sipre.modelo.AltaDocumentosRequest;
import com.mycompany.sipre.modelo.Documento;
import okhttp3.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Consumer;

public class DocumentoController {

    private final String BASE_URL = "http://localhost:8080/documentos";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public void agregarDocumento(Documento documento, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(documento);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.accept(response.isSuccessful());
                response.close();
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(false);
            }
        });
    }

    public void obtenerTodosLosDocumentos(Consumer<List<Documento>> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful() || responseBody == null) {
                        callback.accept(null);
                        return;
                    }
                    String json = responseBody.string();
                    Type tipoLista = new TypeToken<List<Documento>>() {}.getType();
                    List<Documento> documentos = gson.fromJson(json, tipoLista);
                    callback.accept(documentos);
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

    public void obtenerDocumentoPorFolio(int folio, Consumer<Documento> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + folio)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Documento documento = gson.fromJson(responseBody.string(), Documento.class);
                        callback.accept(documento);
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

    public void obtenerDocumentosPorEstatus(String estatus, Consumer<List<Documento>> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/estatus/" + estatus)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Type tipoLista = new TypeToken<List<Documento>>() {}.getType();
                        List<Documento> documentos = gson.fromJson(responseBody.string(), tipoLista);
                        callback.accept(documentos);
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

    public void obtenerDocumentosPorTipo(int idTipo, Consumer<List<Documento>> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/tipo/" + idTipo)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        Type tipoLista = new TypeToken<List<Documento>>() {}.getType();
                        List<Documento> documentos = gson.fromJson(responseBody.string(), tipoLista);
                        callback.accept(documentos);
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

    public void actualizarDocumento(int folioAnterior, Documento documento, Consumer<Boolean> callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = gson.toJson(documento);
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(BASE_URL + "/" + folioAnterior)
                .put(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.accept(response.isSuccessful());
                response.close();
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(false);
            }
        });
    }

    public void eliminarDocumento(int folio, Consumer<Boolean> callback) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/" + folio)
                .delete()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.accept(response.isSuccessful());
                response.close();
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.accept(false);
            }
        });
    }
    
    // alta documento
    public void altaDocumento(String tipoDocumento, int cantidad, int folioInicial, Integer folioFinal, String fechaIngreso, int idUsuario, Consumer<Boolean> callback) {
    OkHttpClient client = new OkHttpClient();

    // Crear objeto JSON usando Gson
    AltaDocumentosRequest altaRequest = new AltaDocumentosRequest();
    altaRequest.setTipoDocumento(tipoDocumento);
    altaRequest.setCantidad(cantidad);
    altaRequest.setFolioInicial(folioInicial);
    altaRequest.setFolioFinal(folioFinal);
    altaRequest.setFechaIngreso(fechaIngreso);
    altaRequest.setIdUsuario(idUsuario);

    MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    RequestBody body = RequestBody.create(gson.toJson(altaRequest), JSON);

    Request request = new Request.Builder()
            .url(BASE_URL + "/alta-lote")
            .post(body)
            .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            try {
                callback.accept(response.isSuccessful());
            } finally {
                response.close();
            }
        }

        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
            callback.accept(false);
        }
    });
}
}
