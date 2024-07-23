
package org.example.tacocloud.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@RestResource(rel="tacos", path="tacos")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, message="Name must be at least 5 characters long")
    private String name;

    private Date createdAt = new Date();

    @Size(min = 1, message="You must choose at least 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
