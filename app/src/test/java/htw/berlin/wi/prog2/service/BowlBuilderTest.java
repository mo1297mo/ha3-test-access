package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Bowl;
import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BowlBuilderTest {

    private final BowlBuilder builder  = new BowlBuilder();

    private final Ingredient lachs = new Ingredient("Lachs", new BigDecimal("0.01"), 2000);
    private final Ingredient reis = new Ingredient("Reis", new BigDecimal("0.02"), 1000);

    @Test
    @DisplayName("can build a precomputed bowl with two ingredients")
    void buildABowl() {
        builder.setCreationStyle(BowlBuilder.CreationStyle.PRECOMPUTED);
        Bowl bowl = builder.add(reis).add(lachs).build();

        assertEquals(List.of("Reis", "Lachs"), bowl.getIngredientNames());
        assertEquals(new BigDecimal("0.03"), bowl.calculatePrice());
        assertEquals(3000, bowl.calculateCalories());
    }

    @Test
    @DisplayName("can build two precomputed bowls after another without mixing things up")
    void buildTwoBowls() {
        builder.setCreationStyle(BowlBuilder.CreationStyle.PRECOMPUTED);
        Bowl bowl1 = builder.add(reis).add(lachs).build();
        Bowl bowl2 = builder.add(reis).add(reis).build();

        assertEquals(List.of("Reis", "Lachs"), bowl1.getIngredientNames());
        assertEquals(List.of("Reis", "Reis"), bowl2.getIngredientNames());
    }

    @Test
    @DisplayName("can build a dynamically computed bowl with two ingredients")
    void buildABowlDynamically() {
        builder.setCreationStyle(BowlBuilder.CreationStyle.DYNAMICALLY_COMPUTED);
        Bowl bowl = builder.add(reis).add(lachs).build();

        assertEquals(List.of("Reis", "Lachs"), bowl.getIngredientNames());
        assertEquals(new BigDecimal("0.03"), bowl.calculatePrice());
        assertEquals(3000, bowl.calculateCalories());
    }

    @Test
    @DisplayName("can build two dynamically computed bowls after another without mixing things up")
    void buildTwoBowlsDynamically() {
        builder.setCreationStyle(BowlBuilder.CreationStyle.DYNAMICALLY_COMPUTED);
        Bowl bowl1 = builder.add(reis).add(lachs).build();
        Bowl bowl2 = builder.add(reis).add(reis).build();

        assertEquals(List.of("Reis", "Lachs"), bowl1.getIngredientNames());
        assertEquals(List.of("Reis", "Reis"), bowl2.getIngredientNames());
    }

    @Test
    @DisplayName("a bowl should have at least two ingredients")
    void checkNumberOfIngredients() {
        assertThrows(IllegalBowlException.class, builder::build);
        assertThrows(IllegalBowlException.class, () -> builder.add(reis).build());
    }
}
