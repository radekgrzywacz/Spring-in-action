package org.example.tacocloud.domains;

import lombok.*;

import java.util.List;


@Data
public class Taco {

    private String name;

    private List<Ingredient> ingredients;
}
