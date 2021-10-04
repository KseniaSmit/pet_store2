package com.mirea.petshop.repositories;

import com.mirea.petshop.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Интерфейс для получения информации о товарах в корзине из таблиц базы данных
 * @author Сметанникова Ксения
 */
public interface IBasketRepository extends JpaRepository<Basket, Integer> {
    /**
     * Метод поиска добавленных в корзину товаров по идентификатору пользователя
     * @param userId Идентификатор пользователя
     * @return Возвращает список продуктов из корзины
     */
    List<Basket> findAllByUserId(int userId);
    /**
     * Метод поиска товара добавленного в корзину по идентификатору
     * @param id Идентификатор продукта в корзине
     * @return Возвращает продукт добавленный в корзину
     */
    Basket findById(int id);
    /**
     * Метод поиска продукта, добавленного в корзину, по идентификаторам пользователя и продукта
     * @param userId Идентификатор пользователя
     * @param productId Идентификатор продукта
     * @return Возвращает продукт из корзины
     */
    Basket findByUserIdAndProductId(int userId, int productId);
    /**
     * Метод удаления добавленного товара в корзину по идентификатору
     * @param id Идентификатор продукта в корзине
     * @return Возвращает результат удаления
     */
    Long deleteById(int id);
    /**
     * Метод очищения корзины определенного пользователя
     * @param userId Идентификатор пользователя
     * @return Возвращает результат удаления
     */
    @Transactional
    Long deleteAllByUserId(int userId);

}
