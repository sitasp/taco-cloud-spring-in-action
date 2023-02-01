package com.sage.tacocloudspringinaction;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name="createdAt")
    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
