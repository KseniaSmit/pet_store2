package com.mirea.petshop.repositories;


import com.mirea.petshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс для получения информации о пользователях из таблиц базы данных
 * @author Сметанникова Ксения
 */

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    /**
     * Метод поиска пользователя по имени
     * @param username Имя пользователя
     * @return Возвращает пользователя
     */
    User findByUsername(String username);
    /**
     * Метод удаления пользователя по идентификатору
     * @param id Идентификатор пользователя
     * @return Возвращает результат удаления
     */
    Long deleteById(int id);
}
