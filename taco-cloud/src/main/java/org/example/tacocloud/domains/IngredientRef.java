package org.example.tacocloud.domains;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class IngredientRef {
    public final String ingredient;
}