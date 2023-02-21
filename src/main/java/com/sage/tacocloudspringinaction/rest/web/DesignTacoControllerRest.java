package com.sage.tacocloudspringinaction.rest.web;

import com.sage.tacocloudspringinaction.Taco;
import com.sage.tacocloudspringinaction.data.TacoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoControllerRest {
    private final TacoRepository tacoRepo;

    public DesignTacoControllerRest(TacoRepository tacoRepo){
        this.tacoRepo = tacoRepo;
    }

    @GetMapping("/recent") 
    public Iterable<Taco> recentTacos() {
        Pageable pageable = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        Page<Taco> tacos = tacoRepo.findAll(pageable);
        return tacos.getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id){
        Optional<Taco> optTaco = tacoRepo.findById(id);
//        if(optTaco.isPresent()){
//            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return optTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
