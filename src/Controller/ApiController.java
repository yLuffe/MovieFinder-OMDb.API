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
    String jsonString ="";

    // ArrayList com os filmes encontrados
    private ArrayList<Movie> listMovie = new ArrayList<>();

    public Movie searchMovieById(String id) {
        try {
            jsonString = api.search(null, id, 2);
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

            String title = jsonObject.has("Title") ? jsonObject.get("Title").getAsString() : "";
            String year = jsonObject.has("Year") ? jsonObject.get("Year").getAsString() : "";
            String imdbID = jsonObject.has("imdbID") ? jsonObject.get("imdbID").getAsString() : "";
            String genre = jsonObject.has("Genre") ? jsonObject.get("Genre").getAsString() : "";
            String director = jsonObject.has("Director") ? jsonObject.get("Director").getAsString() : "";
            String writer = jsonObject.has("Writer") ? jsonObject.get("Writer").getAsString() : "";
            String plot = jsonObject.has("Plot") ? jsonObject.get("Plot").getAsString() : "";
            String language = jsonObject.has("Language") ? jsonObject.get("Language").getAsString() : "";
            String country = jsonObject.has("Country") ? jsonObject.get("Country").getAsString() : "";
            String posterLink = jsonObject.has("Poster") ? jsonObject.get("Poster").getAsString() : "";
            String type = jsonObject.has("Type") ? jsonObject.get("Type").getAsString() : "";
            String runtime = jsonObject.has("Runtime") ? jsonObject.get("Runtime").getAsString() : "";

            return new Movie(title, year, genre, director, writer, null, plot, language, country, posterLink, imdbID, type, language, runtime);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Movie> searchMovie(String movieName) {
        try {
            jsonString = api.search(movieName.replaceAll(" ", "+").trim(), "null", 1);

            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            JsonArray searchResults = jsonObject.getAsJsonArray("Search");

            for (JsonElement element : searchResults) {
                JsonObject movieJson = element.getAsJsonObject();
                String title = movieJson.get("Title").getAsString();
                String year = movieJson.get("Year").getAsString();
                String imdbID = movieJson.get("imdbID").getAsString();
                Movie movie = new Movie(title, year, imdbID);
                listMovie.add(movie);
            }
            return listMovie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
