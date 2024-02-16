package com.vct.springsecuritylearn.service;

import com.vct.springsecuritylearn.model.Animal;
import com.vct.springsecuritylearn.model.dto.AnimalDTO;
import com.vct.springsecuritylearn.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public List<Animal> findAll() { return repository.findAll(); }

    public List<Animal> findByEspecie(String especie) { return repository.findByEspecieIgnoreCase(especie); }

    public Optional<Animal> findByNome(String nome) { return repository.findByNomeIgnoreCase(nome); }

    public Animal saveAnimal(AnimalDTO animalDTO) { return repository.save(new Animal(animalDTO)); }

}
