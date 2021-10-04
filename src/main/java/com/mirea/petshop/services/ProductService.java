package com.mirea.petshop.services;

import com.mirea.petshop.models.Product;
import com.mirea.petshop.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс-сервис для передачи данных из таблицы Бд с продуктами в контроллер
 * @author Сметанникова Ксения
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    /**
     * Интерфейс для получения информации о продуктах из таблиц базы данных
     */
    private IProductRepository iProductRepository;
    /**
     * Конструктор присваивает значение для объекта интерфейса-репозитория
     * @param iProductRepository Интерфейс для получения информации о продуктах из таблиц базы данных
     */
    @Autowired
    public ProductService(IProductRepository iProductRepository){
        this.iProductRepository=iProductRepository;
    }
    public List<Product> getAllProductsByTypeId(int typeId){
        if (typeId != 0)
            return iProductRepository.findAllByTypeId(typeId);
        else
            return getAllProducts();
    }
    /**
     * Метод получения всех продуктов
     * @return Возвращает список продуктов
     */
    public List<Product> getAllProducts(){return  iProductRepository.findAll();}
    /**
     * Метод получения всех товаров определенного вида
     * @param id Идентификатор вида товара
     * @return Возвращает список продуктов
     */
    public Product getProductById(int id){
        return iProductRepository.findById(id);
    }
}
