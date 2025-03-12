package config;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.net.URI;

public class User {
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public User() {
        try {
            String apiUrl = "https://random-data-api.com/api/v3/projects/27eea969-9ffb-45c3-a4f3-26401d63a4a4";

            HttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(URI.create(apiUrl));

            HttpResponse response = client.execute(request);

            String responseBody = EntityUtils.toString(response.getEntity());

            JSONObject jsonResponse = new JSONObject(responseBody);
            this.username = jsonResponse.getString("first_name");  // Extract first name
            this.email = jsonResponse.getString("email");          // Extract email
            this.password = jsonResponse.getString("password");    // Extract password

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
