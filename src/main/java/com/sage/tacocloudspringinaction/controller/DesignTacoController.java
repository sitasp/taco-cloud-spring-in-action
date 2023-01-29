package com.sage.tacocloudspringinaction.controller;

import com.sage.tacocloudspringinaction.Ingredient;
import com.sage.tacocloudspringinaction.Ingredient.Type;
import com.sage.tacocloudspringinaction.Order;
import com.sage.tacocloudspringinaction.Taco;
import com.sage.tacocloudspringinaction.data.IngredientRepository;
import com.sage.tacocloudspringinaction.data.TacoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
//        model.addAttribute("design", new Taco());

        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("taco") Taco design, Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()){
            log.info("Any errors: " + errors);
            return "design";
        }
        Taco saved = designRepo.save(design);
        order.addDesign(saved);
        log.info("Processiing design: " + design);

        return "redirect:/orders/current";
    }
}
