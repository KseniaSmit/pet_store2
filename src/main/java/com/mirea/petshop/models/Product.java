package com.mirea.petshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
/**
 * Класс модели представления для продукта
 * @author Сметанникова Ксения
 */
@Getter
@Setter
@Entity
@Table(name="products")
public class Product {
    /**
     * Идентификатор товара
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Идентификатор вида товара
     */
    @Column(name="types_id")
    private int typeId;
    /**
     * Название товара
     */
    @Column(name="name", nullable = false)
    private String name;
    /**
     * Цена товара
     */
    @Column(name="price")
    private int price;
    /**
     * Описание товара
     */
    @Column(name="description")
    private String description;
}
