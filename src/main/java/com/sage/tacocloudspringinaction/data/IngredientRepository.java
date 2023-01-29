package com.sage.tacocloudspringinaction.data;

import com.sage.tacocloudspringinaction.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);

}
