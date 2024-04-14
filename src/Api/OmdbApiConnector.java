package Api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class OmdbApiConnector {

    // Api Key
    private static final String API_KEY = "46a38fae";
    // Api Url
    private String apiUrl = "http://www.omdbapi.com/?apikey=" + API_KEY;

    // Método buscar filme
    public String search(String movieName, String imdbId, int searchOption) {
        // Option 1 == SearchByName
        if (searchOption == 1) {
            apiUrl = apiUrl + "&s=" + movieName;
        }
        // Option 2 == SearchByImdbID
        if (searchOption == 2) {
            apiUrl = apiUrl + "&i=" + imdbId;
        }

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(apiUrl);

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                return responseBody;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
