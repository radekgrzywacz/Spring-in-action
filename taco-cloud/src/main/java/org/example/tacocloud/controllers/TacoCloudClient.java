package org.example.tacocloud.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.tacocloud.domains.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TacoCloudClient {

    private RestTemplate rest;

    public TacoCloudClient(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

//    public Ingredient getIngredientById(String ingredientId) {
//        return rest.getForObject("http://localhost:8080/ingredients/{id}", Ingredient.class, ingredientId);
//    }

//    public Ingredient getIngredient(String ingredientId) {
//        Map<String, String> urlVariables = new HashMap<>();
//        urlVariables.put("id", ingredientId);
//
//        return rest.getForObject("http://localhost:8080/ingredients/{id}", Ingredient.class, urlVariables);
//    }

//    public Ingredient getIngredientById(String ingredientId) {
//        Map<String, String> urlVariables = new HashMap<>();
//        urlVariables.put("id", ingredientId);
//
//        URI url = UriComponentsBuilder
//                .fromHttpUrl("http://localhost:8080/ingredients/{id}")
//                .build(urlVariables);
//
//        return rest.getForObject(url, Ingredient.class);
//    }


    public Ingredient getIngredientById(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
                rest.getForEntity("http://localhost:8080/ingredients/{id}", Ingredient.class, ingredientId);

        log.info("Fetched tim: {}", responseEntity.getHeaders().getDate());

        return responseEntity.getBody();
    }

    public void updateIngredient(Ingredient ingredient) {
        rest.put("http://localhost:8080/ingredients/{id}", ingredient, ingredient.getId());
    }

    public void deleteIngredient(Ingredient ingredient) {
        rest.delete("http://localhost:8080/ingredients/{id}", ingredient.getId());
    }

    public Ingredient createObject(Ingredient ingredient) {
        return rest.postForObject("http://localhost:8080/ingredients", ingredient, Ingredient.class);
    }

//    public java.net.URI createIngredient(Ingredient ingredient) {
//        return rest.postForLocation("http://localhost:8080/ingredients", ingredient);
//    }

    public Ingredient createIngredient(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity = rest.postForEntity("http://localhost:8080/ingredients",
                ingredient, Ingredient.class);
        log.info("New resource created at {}", responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}
