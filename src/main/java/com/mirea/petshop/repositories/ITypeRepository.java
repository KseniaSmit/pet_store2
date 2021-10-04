package com.mirea.petshop.repositories;

import com.mirea.petshop.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс для получения информации о видая изделий из таблиц базы данных
 * @author Сметанникова Ксения
 */
@Repository
public interface ITypeRepository extends JpaRepository<Type, Integer> {

}
