package ru.dmitry.postrequest.services;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitry.postrequest.dao.CountryRepository;
import ru.dmitry.postrequest.entities.City;
import ru.dmitry.postrequest.entities.Country;
import ru.dmitry.postrequest.utils.Request;
import ru.dmitry.postrequest.utils.Response;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    private void save(List<Country> countries) {

        if (countries != null && !countries.isEmpty())
        for (Country country : countries) {
            if (country.getCities() != null && !country.getCities().isEmpty()) {
                for (City city : country.getCities()) {
                    city.setCountry(country);
                }
            }
        }

        countryRepository.save(countries);
    }

    public void sendRequest(Request request) {
        try {

            URL url = new URL("http://tripcomposer.net/rest/test/countries/get");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            mapper.writeValue(wr, request);
            wr.flush();
            wr.close();
            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder builder = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                builder.append(inputLine);
            }
            in.close();

            System.out.println(builder.toString());

            Response response = mapper.readValue(builder.toString(), Response.class);
            save(response.getCountries());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
