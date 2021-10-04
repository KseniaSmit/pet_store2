package com.mirea.petshop.services;

import com.mirea.petshop.models.Basket;
import com.mirea.petshop.repositories.IBasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс-сервис для передачи данных из таблицы Бд с добавленными товарами в контроллер
 */
@Service
@RequiredArgsConstructor
public class BasketService {
    /**
     * Интерфейс для получения информации о товарах в корзине из таблиц базы данных
     */
    private IBasketRepository iBasketRepository;

    /**
     * Конструктор присваивает значение для объекта интерфейса-репозитория
     * @param iBasketRepository Интерфейс для получения информации о товарах в корзине из таблиц базы данных
     */
    @Autowired
    public BasketService(IBasketRepository iBasketRepository){
        this.iBasketRepository=iBasketRepository;
    }
    /**
     * Метод получения добавленного в корзину товара по идентификатору пользователя и идентификатору продукта
     * @param userId Идентификатор пользователя
     * @param productId Идентификатор продукта
     * @return Возвращает товар добавленный в корзину
     */
    public Basket getBasketByUserIdAndProductId(int userId, int productId){
        return  iBasketRepository.findByUserIdAndProductId(userId, productId);
    }
    /**
     * Метод сохраняет товар добавленный в корзину в БД
     * @param basket Объект товара добавленного в корзину
     */
    public void saveBasket(Basket basket){
        iBasketRepository.save(basket);
    }
    /**
     * Метод получения добавленных в корзину товаров по идентификатору пользователя
     * @param userId Идентификатору пользователя
     * @return Возвращает список продуктов из корзины
     */
    public List<Basket> getBasketByUserId(int userId){
        return iBasketRepository.findAllByUserId(userId);
    }
    /**
     * Метод получения продукта по идентификатору
     * @param id Идентификатор продукта
     * @return Возвращает продукт из корзины
     */
    public Basket getBasketById(int id){
        return iBasketRepository.findById(id);
    }
    /**
     * Метод удаления добавленного товара в корзину по идентификатору
     * @param id Идентификатор продукта
     */
    public void deleteBasketById(int id){
        iBasketRepository.deleteById(id);
    }
    /**
     * Метод очищения корзины определенного пользователя
     * @param userId Идентификатор пользователя
     */
    public void deleteAllByUserId(int userId){
        iBasketRepository.deleteAllByUserId(userId);
    }


}
