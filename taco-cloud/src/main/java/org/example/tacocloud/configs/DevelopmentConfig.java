package org.example.tacocloud.configs;

import org.example.tacocloud.domains.Ingredient;
import org.example.tacocloud.domains.User;
import org.example.tacocloud.repositories.IngredientRepository;
import org.example.tacocloud.repositories.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.tacocloud.domains.Ingredient.Type;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@Profile("!prod")
public class DevelopmentConfig {


    @Bean
    public ApplicationRunner ingredientDataLoader(IngredientRepository repo) {
        return args -> {
            repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        };
    }

    @Bean
    public ApplicationRunner userDataLoader(UserRepository repo, PasswordEncoder passwordEncoder) {
        return args -> {
            repo.save(new User("radox", passwordEncoder.encode("password"), "Radek", "Rolna", "Kato", "Slask", "40-555", "502871468"));
        };
    }



}
