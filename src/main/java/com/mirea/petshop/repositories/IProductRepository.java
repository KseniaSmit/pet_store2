package com.mirea.petshop.repositories;

import com.mirea.petshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Интерфейс для получения информации о продуктах из таблиц базы данных
 * @author Сметанникова Ксения
 */
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    /**
     * Метод для поиска продуктов по идентификатору вида изделий
     * @param typeId Идентификатор вида изделий
     * @return Возвращает список продуктов, соответствующих виду
     */
    List<Product> findAllByTypeId(int typeId);
    /**
     * Метод поиска продукта по идентификатору
     * @param id Идентификатор продукта
     * @return Возвращает продукт
     */
    Product findById(int id);
}

