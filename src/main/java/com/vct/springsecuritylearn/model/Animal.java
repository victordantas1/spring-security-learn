package com.vct.springsecuritylearn.model;

import com.vct.springsecuritylearn.model.dto.AnimalDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_animais")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Long id;
    @Column(name = "animal_nome", nullable = false)
    private String nome;
    @Column(name = "animal_especie", nullable = false)
    private String especie;

    public Animal(AnimalDTO animal) {
        this.nome = animal.nome();
        this.especie = animal.especie();
    }

}
