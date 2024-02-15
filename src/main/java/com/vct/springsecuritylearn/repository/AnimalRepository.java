package com.vct.springsecuritylearn.repository;

import com.vct.springsecuritylearn.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByEspecie(String especie);
    Optional<Animal> findByNome(String nome);
}
