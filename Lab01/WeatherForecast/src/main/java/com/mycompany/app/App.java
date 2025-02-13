package com.mycompany.app;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    private static final String URL = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json";
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String jsonData = response.body().string();

            // Parse JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            // Print the parsed data
            System.out.println(jsonNode.toPrettyString());

            // You can further process the JSON here, e.g., extracting temperature, date, etc.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
