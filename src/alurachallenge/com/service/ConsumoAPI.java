package alurachallenge.com.service;

import alurachallenge.com.modelo.ExchangeRecords;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public ExchangeRecords obtenerDatos() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/dddd218ebf9999c98af58b30/latest/MXN?dddd218ebf9999c98af58b30");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body() , ExchangeRecords.class);
    }
}