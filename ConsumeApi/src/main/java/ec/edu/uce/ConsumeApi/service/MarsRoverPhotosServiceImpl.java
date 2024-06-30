package ec.edu.uce.ConsumeApi.service;

import ec.edu.uce.ConsumeApi.model.Rover;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarsRoverPhotosServiceImpl implements MarsRoverPhotosService {
    private static final String API_KEY = "gBrG8uq2CLJ8NQpqd7WWGn0oCpRb06WbWbTD2zr1"; // Reemplaza con tu API Key
    private static final String API_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";

    private final OkHttpClient client;

    public MarsRoverPhotosServiceImpl() {
        this.client = new OkHttpClient();
    }

    @Override
    public List<Rover> getPhotos(String date, String camera, int sol, int page) {
        List<Rover> roverList = new ArrayList<>();
        int currentPage = 1;
        boolean morePages = true;

        while (morePages) {
            String url = API_URL + "?earth_date=" + date + "&camera=" + camera + "&sol=" + sol + "&page=" + currentPage + "&api_key=" + API_KEY;

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                String responseData = response.body().string();
                JSONObject jsonObject = new JSONObject(responseData);
                JSONArray photos = jsonObject.getJSONArray("photos");

                for (int i = 0; i < photos.length(); i++) {
                    JSONObject photo = photos.getJSONObject(i);
                    Rover rover = new Rover();
                    rover.setImgSrc(photo.getString("img_src"));
                    rover.setId(photo.getJSONObject("rover").getInt("id"));
                    rover.setName(photo.getJSONObject("rover").getString("name"));
                    rover.setLandingDate(photo.getJSONObject("rover").getString("landing_date"));
                    rover.setLaunchDate(photo.getJSONObject("rover").getString("launch_date"));
                    rover.setStatus(photo.getJSONObject("rover").getString("status"));
                    rover.setMaxSol(photo.getJSONObject("rover").getInt("max_sol"));
                    rover.setMaxDate(photo.getJSONObject("rover").getString("max_date"));
                    rover.setTotalPhotos(photo.getJSONObject("rover").getInt("total_photos"));
                    roverList.add(rover);
                }

                // Verificar si hay más páginas de resultados
                if (photos.length() < 25) { // 25 es el número máximo de fotos por página según la API
                    morePages = false;
                } else {
                    currentPage++;
                }

            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }

        // Aplicar filtros a roverList si es necesario
        List<Rover> filteredRovers = roverList.stream()
                .filter(rover -> rover.getMaxSol() > 2000)
                // Puedes agregar más filtros aquí según tus necesidades
                .collect(Collectors.toList());

        return filteredRovers;
    }
}