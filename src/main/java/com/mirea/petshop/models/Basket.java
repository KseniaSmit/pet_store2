package com.mirea.petshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Класс модели представления для товаров в корзине
 * @author Сметанникова Ксения
 */
@Getter
@Setter
@Entity
@Table(name="basket")
public class Basket {
    /**
     * Идентификатор товара в корзине
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    /**
     * Идентификатор пользователя
     */
    @Column(name = "user_id")
    private int userId;
    /**
     * Идентификатор товара
     */
    @Column(name = "product_id")
    private int productId;
    /**
     * Количество товара
     */
    @Column(name = "product_count")
    private int productCount;
}
