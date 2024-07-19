package org.example.tacocloud.repositories;

import org.example.tacocloud.domains.Ingredient;

import java.util.Optional;

public interface IngredientRepository{
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}