package Controller;

import Api.OmdbApiConnector;
import Model.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;

public class ApiController {

    OmdbApiConnector api = new OmdbApiConnector();
    Gson gson = new Gson();

    // ArrayList com os filmes encontrados
    private ArrayList<Movie> listMovie = new ArrayList<>();

    public ArrayList<Movie> searchMovie(String movieName) {
        try {
            String jsonString = api.search(movieName.replaceAll(" ", "+").trim(), "null", 1);

            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            JsonArray searchResults = jsonObject.getAsJsonArray("Search");

            for (JsonElement element : searchResults) {
                JsonObject movieJson = element.getAsJsonObject();
                String title = movieJson.get("Title").getAsString();
                String year = movieJson.get("Year").getAsString();
                String imdbID = movieJson.get("imdbID").getAsString();
                //String genre = movieJson.get("Genre").getAsString();
                //String director = movieJson.get("Director").getAsString();
                //String writer = movieJson.get("Writer").getAsString();
                //String plot = movieJson.get("Plot").getAsString();
                //String language = movieJson.get("Language").getAsString();
                //String country = movieJson.get("Country").getAsString();
                //String posterLink = movieJson.get("Poster").getAsString();
                //String type = movieJson.get("Type").getAsString();
                //String runtime = movieJson.get("Runtime").getAsString();

                Movie movie = new Movie(title, "", "", "", "", null, "", "", "", "", imdbID, "", "", "");
                listMovie.add(movie);
            }

            return listMovie;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // Singleton
    private static ApiController instance;

    public synchronized static ApiController getInstance() {
        if (instance == null) {
            instance = new ApiController();
        }
        return instance;
    }
}
