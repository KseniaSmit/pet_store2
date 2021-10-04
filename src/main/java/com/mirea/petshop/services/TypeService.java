package com.mirea.petshop.services;

import com.mirea.petshop.models.Type;
import com.mirea.petshop.repositories.ITypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс-сервис для передачи данных из таблицы Бд с видами товаров в контроллер
 * @author Сметанникова Ксения
 */
@Service
@RequiredArgsConstructor
public class TypeService {
    /**
     * Интерфейс для получения информации о видах товаров из таблиц базы данных
     */
    private ITypeRepository iTypeRepository;
    /**
     * Конструктор присваивает значение для объекта интерфейса-репозитория
     * @param iTypeRepository Интерфейс для получения информации о видах товаров из таблиц базы данных
     */
    @Autowired
    public TypeService(ITypeRepository iTypeRepository){
        this.iTypeRepository=iTypeRepository;
    }
    /**
     * Метод получения всех видов товаров
     * @return Возвращает список видов товаров
     */
    public List<Type> getAllTypes(){
        return iTypeRepository.findAll();
    }

}
