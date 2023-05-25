package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.math.BigDecimal;
import java.util.*;

// Eine statische Datenbank-Klasse
public class Menu {
    private Menu() {}

    public static Map<Long, Ingredient> base = Map.of(
            1L, new Ingredient("Reis", new BigDecimal("0.6"), 120),
            2L, new Ingredient("Quinoa", new BigDecimal("0.7"), 100));
    public static Map<Long, Ingredient> protein = Map.of(
            3L, new Ingredient("Lachs", new BigDecimal("0.9"), 90),
            4L, new Ingredient("Tofu", new BigDecimal("0.9"), 80));
    public static Map<Long, Ingredient> topping = Map.of(
            5L, new Ingredient("Tomate", new BigDecimal("0.4"), 20),
            6L, new Ingredient("Edamame", new BigDecimal("0.6"), 30),
            7L, new Ingredient("Avocado", new BigDecimal("0.6"), 40),
            8L, new Ingredient("Zwiebeln", new BigDecimal("0.3"), 20));
    public static Map<Long, Ingredient> sauces = Map.of(
            9L, new Ingredient("Mayo", new BigDecimal("0.3"), 40),
            10L, new Ingredient("Sesam", new BigDecimal("0.3"), 40));

    public static Map<Long, Ingredient> getAllArticles() {
        Map<Long, Ingredient> articles = new HashMap<>();
        articles.putAll(base);
        articles.putAll(protein);
        articles.putAll(topping);
        articles.putAll(sauces);
        return articles;
    }


}
