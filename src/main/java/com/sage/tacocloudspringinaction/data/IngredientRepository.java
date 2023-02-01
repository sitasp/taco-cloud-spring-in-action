package com.sage.tacocloudspringinaction.data;

import com.sage.tacocloudspringinaction.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository  extends CrudRepository<Ingredient, String> {

}
