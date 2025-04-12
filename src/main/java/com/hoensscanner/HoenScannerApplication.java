package com.hoensscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoensscanner.api.SearchResult;
import com.hoensscanner.resources.SearchResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {
    public static void main(String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public void run(HoenScannerConfiguration configuration, Environment environment) {
        ObjectMapper mapper = new ObjectMapper();
        List<SearchResult> allResults = new ArrayList<>();

        try {
            // Load rental cars
            try (InputStream is = getClass().getResourceAsStream("/rental_cars.json")) {
                allResults.addAll(mapper.readValue(is, new TypeReference<List<SearchResult>>() {}));
            }

            // Load hotels
            try (InputStream is = getClass().getResourceAsStream("/hotels.json")) {
                allResults.addAll(mapper.readValue(is, new TypeReference<List<SearchResult>>() {}));
            }

            // Register the search resource
            environment.jersey().register(new SearchResource(allResults));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load search data", e);
        }
    }
}