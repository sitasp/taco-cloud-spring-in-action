package com.sage.tacocloudspringinaction.web;

import com.sage.tacocloudspringinaction.Ingredient;
import com.sage.tacocloudspringinaction.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
        return optionalIngredient.orElse(null);
    }

//    @Override
//    public <T extends Ingredient> Converter<String, T> getConverter(Class<T> targetType) {
//        return null;
//    }
}
