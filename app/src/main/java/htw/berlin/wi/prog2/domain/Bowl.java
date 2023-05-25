package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;
import java.util.List;

public interface Bowl {
    BigDecimal calculatePrice();
    int calculateCalories();
    List<String> getIngredientNames();
}
