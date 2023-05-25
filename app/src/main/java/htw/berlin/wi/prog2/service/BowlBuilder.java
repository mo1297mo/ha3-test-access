package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.DynamicallyComputedBowl;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.PrecomputedBowl;
import htw.berlin.wi.prog2.domain.Bowl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BowlBuilder {

    private List<Ingredient> ingredients = new ArrayList<>();

    public enum CreationStyle {
        PRECOMPUTED,
        DYNAMICALLY_COMPUTED
    }

    private CreationStyle creationStyle;

    public void setCreationStyle(CreationStyle creationStyle) {
        this.creationStyle = creationStyle;
    }

    public BowlBuilder add(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public Bowl build() {
        if(ingredients.size() < 2) throw new IllegalBowlException("Nicht genügend Zutaten");
        return creationStyle == CreationStyle.PRECOMPUTED ? buildPrecomputed() : buildDynamicallyComputed();
    }

    private Bowl buildPrecomputed() {
        BigDecimal price = BigDecimal.ZERO;
        int calories = 0;
        List<String> ingredientNames = new ArrayList<>();

        for (Ingredient ing : ingredients) {
            price = price.add(ing.getPrice());
            calories += ing.getCalories();
            ingredientNames.add(ing.getName());
        }
        ingredients.clear();

        return new PrecomputedBowl(price, calories, ingredientNames);
    }

    private Bowl buildDynamicallyComputed() {
        List<Ingredient> ingsToPass = List.copyOf(ingredients);
        ingredients.clear();
        return new DynamicallyComputedBowl(ingsToPass);
    }

    public BowlBuilder(CreationStyle creationStyle) {
        this.creationStyle = creationStyle;
    }

    public BowlBuilder() {
        this(CreationStyle.PRECOMPUTED);
    }
}
