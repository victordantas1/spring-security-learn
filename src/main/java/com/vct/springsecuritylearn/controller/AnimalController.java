package com.vct.springsecuritylearn.controller;

import com.vct.springsecuritylearn.model.Animal;
import com.vct.springsecuritylearn.model.dto.AnimalDTO;
import com.vct.springsecuritylearn.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("animais")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/nome")
    public ResponseEntity<Animal> findByNome(@RequestParam String nome) {
       Animal animal = service.findByNome(nome).orElseThrow(() -> new RuntimeException("Animal nao encontrado"));
       return ResponseEntity.ok().body(animal);
    }

    @GetMapping("/especie")
    public ResponseEntity<List<Animal>> findByEspecie(@RequestParam String especie) {
        return ResponseEntity.ok().body(service.findByEspecie(especie));
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody @Validated AnimalDTO animalDTO) {
        Animal animal = service.saveAnimal(animalDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(animal.getId()).toUri();
        return ResponseEntity.created(uri).body(animal);
    }

}
