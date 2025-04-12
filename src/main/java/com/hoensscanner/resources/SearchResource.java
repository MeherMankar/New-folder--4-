package com.hoensscanner.resources;

import com.hoensscanner.api.Search;
import com.hoensscanner.api.SearchResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SearchResource {
    private final List<SearchResult> allResults;

    public SearchResource(List<SearchResult> results) {
        this.allResults = results;
    }

    @POST
    public List<SearchResult> search(Search search) {
        return allResults.stream()
                .filter(result -> result.getCity().equalsIgnoreCase(search.getCity()))
                .collect(Collectors.toList());
    }
}
