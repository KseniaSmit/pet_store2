package com.mirea.petshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Класс модели представления для вида изделия
 * @author Сметанникова Ксения
 */
@Getter
@Setter
@Entity
@Table(name = "types")
public class Type {
    /**
     * Идентификатор вида товара
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Название вида товара
     */
    @Column(name = "name", nullable = false)
    private String name;
}
